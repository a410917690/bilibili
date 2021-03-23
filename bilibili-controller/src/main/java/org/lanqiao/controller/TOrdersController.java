package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.config.AlipayConfig;
import org.lanqiao.entity.TOrders;
import org.lanqiao.service.TOrdersService;
import org.lanqiao.util.common.OrderEnum;
import org.lanqiao.util.idGenerator.Snowflake;
import org.lanqiao.util.result.Result;
import org.lanqiao.vo.OrdersVo;
import org.lanqiao.vo.TOrderToOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.lanqiao.util.common.Common.*;
import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.controller
 * @ClassName:TOrdersController
 * @Description:
 * @Date 2021/2/18 11:56
 */
@CrossOrigin
@Controller
public class TOrdersController {

    @Reference
    TOrdersService tOrdersService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("getAllOrders")
    public Result queryAll() {
        return setResultSuccess(this.tOrdersService.queryAll());
    }

    @Autowired
    Snowflake snowflake;


    @ApiOperation("生成订单")
    @ResponseBody
    @PostMapping("insertOrder")
    public Result insertOrder(Integer con_no, String i_name, Float money, Integer i_no) throws AlipayApiException {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String o_no = ft.format(date) + UUID.randomUUID().toString();
        /*雪花算法*/
        long o_no = snowflake.nextId();
        TOrders tOrders = new TOrders();
        tOrders.setO_no(o_no);
        tOrders.setMoney(money);
        tOrders.setI_no(i_no);
        tOrders.setI_name(i_name);
        tOrders.setCon_no(con_no);
        Gson gson = new GsonBuilder().create();
        kafkaTemplate.send("test", gson.toJson(tOrders));
        TOrders tOrder = tOrdersService.insertOrder(tOrders.getO_no(), tOrders.getCon_no(), tOrders.getI_name(), tOrders.getMoney(), tOrders.getI_no());
        OrdersVo ordersVo = TOrderToOrderVo.ToOrderVo(tOrder);

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //这里设置支付后跳转的地址
        alipayRequest.setReturnUrl(ordersVo.getRetUrl());
        //订单编号
        String out_trade_no = ordersVo.getO_no().toString();
        //付款金额，必填
        String total_amount = ordersVo.getMoney().toString();
        //订单名称，必填
        String subject = ordersVo.getI_name();
        //商品描述，可空
        String body = "购买大会员，番剧随心看";
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "5m";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String form = alipayClient.pageExecute(alipayRequest, "get").getBody();
        System.out.println(form);

//        ModelAndView  model = new ModelAndView("redirect:" + form);
        Integer flag = tOrdersService.updateOrder(o_no);
        if (flag != 0) {
            if (QGVIP.equals(subject)) {
                tOrdersService.to1Vip(con_no);
                stringRedisTemplate.opsForValue().set(con_no.toString(),total_amount,30,TimeUnit.DAYS);
            } else if (YDVIP.equals(subject)) {
                tOrdersService.to1Vip(con_no);
                stringRedisTemplate.opsForValue().set(con_no.toString(),total_amount,30,TimeUnit.DAYS);
            } else if (JDVIP.equals(subject)) {
                tOrdersService.to1Vip(con_no);
                stringRedisTemplate.opsForValue().set(con_no.toString(),total_amount,90,TimeUnit.DAYS);
            } else if (NDVIP.equals(subject)) {
                tOrdersService.to1Vip(con_no);
                stringRedisTemplate.opsForValue().set(con_no.toString(),total_amount,365,TimeUnit.DAYS);
            } else {
                return null;
            }
        } else {
            return null;
        }
        return setResultSuccess(200, "success", form);
    }


    @ApiOperation("生成订单")
    @ResponseBody
    @PostMapping("deleteOrders")
    public Result deleteOrder(Long o_no) {
        return setResultSuccess(this.tOrdersService.deleteOrder(o_no));
    }

    @ApiOperation("修改订单")
    @ResponseBody
    @PostMapping("updateOrder")
    public Result updateOrder(Long o_no) {
        return setResultSuccess(this.tOrdersService.updateOrder(o_no));
    }

    @ApiOperation("通过订单号查询订单")
    @ResponseBody
    @PostMapping("queryOrder")
    public Result queryOrder(Long o_no) {
        return setResultSuccess(this.tOrdersService.queryOrder(o_no));
    }

    /**
     *
     * @param num 设置秒杀量
     * @param second 设置秒杀时间
     * @return
     */
    @ApiOperation("开始秒杀活动")
    @ResponseBody
    @PostMapping("setSecKill")
    public Result setSecKill(int num,int second) {
        stringRedisTemplate.opsForValue().set("key", String.valueOf(num), Duration.ofSeconds(second));
        return setResultSuccess();
    }

    @ApiOperation("秒杀")
    @ResponseBody
    @RequestMapping("/secKill")
    public Result sk(Integer con_no) {
        String lockKey = "pro01";
        String clientId = con_no.toString();
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 2, TimeUnit.SECONDS);
            if (!result) {
                return setResultError(400, BUY_FAIL, "secKillFail.html");
            }
            if(stringRedisTemplate.getExpire("key") == -1){
                return setResultError(400, BUY_FAIL, "secKillFail.html");
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("key"));

            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("key", realStock + "");
                System.out.println("扣减成功！库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足！");
                return setResultSuccess(200, BUY_SUC, "secKillFail.html");
            }
        } finally {
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                stringRedisTemplate.delete(lockKey);
            }
        }
//        ModelAndView modelAndView = new ModelAndView("redirect:secKillOrder.html");
        return setResultSuccess(200, BUY_SUC, "secKillOrder.html");
    }

}
