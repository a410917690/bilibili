package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lanqiao.config.AlipayConfig;
import org.lanqiao.config.kafka.Consumer;
import org.lanqiao.entity.TOrders;
import org.lanqiao.service.TOrdersService;
import org.lanqiao.util.result.Result;
import org.lanqiao.vo.OrdersVo;
import org.lanqiao.vo.TOrderToOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @ResponseBody
    @PostMapping("getAllOrders")
    public Result queryAll() {
        return setResultSuccess(this.tOrdersService.queryAll());
    }

    @ResponseBody
    @PostMapping("insertOrder")
    public Result insertOrder(Integer con_no, String i_name, Float money, Integer i_no) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String o_no = ft.format(date) + UUID.randomUUID().toString();

        TOrders tOrders = new TOrders();
        tOrders.setO_no(o_no);
        tOrders.setMoney(money);
        tOrders.setI_no(i_no);
        tOrders.setI_name(i_name);
        tOrders.setCon_no(con_no);
        Gson gson = new GsonBuilder().create();
        kafkaTemplate.send("test", gson.toJson(tOrders));
        tOrdersService.insertOrder(tOrders.getO_no(),tOrders.getCon_no(),tOrders.getI_name(),tOrders.getMoney(),tOrders.getI_no());

        return setResultSuccess(tOrders);
    }

    @RequestMapping("aliPay")
    public ModelAndView goAlipay(String o_no) throws Exception {

        TOrders tOrder = tOrdersService.queryOrder(o_no);
        OrdersVo ordersVo = TOrderToOrderVo.ToOrderVo(tOrder);

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //这里设置支付后跳转的地址
        alipayRequest.setReturnUrl(ordersVo.getRetUrl());
        //订单编号
        String out_trade_no = ordersVo.getO_no();
        //付款金额，必填
        String total_amount = ordersVo.getMoney().toString();
        //订单名称，必填
        String subject = ordersVo.getI_name();
        //商品描述，可空
        String body = ordersVo.getI_name();
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

        ModelAndView  model = new ModelAndView("redirect:" + form);
        tOrdersService.updateOrder(o_no);
        return model;
    }

    @ResponseBody
    @PostMapping("deleteOrders")
    public Result deleteOrder(String o_no) {
        return setResultSuccess(this.tOrdersService.deleteOrder(o_no));
    }

    @ResponseBody
    @PostMapping("updateOrder")
    public Result updateOrder(String o_no) {
        return setResultSuccess(this.tOrdersService.updateOrder(o_no));
    }

    @ResponseBody
    @PostMapping("queryOrder")
    public Result queryOrder(String o_no) {
        return setResultSuccess(this.tOrdersService.queryOrder(o_no));
    }

    @ResponseBody
    @PostMapping("setSecKill")
    public Result setSecKill() {
        stringRedisTemplate.opsForValue().set("key", String.valueOf(1000), Duration.ofSeconds(60*60*24*3));
        return setResultSuccess();
    }

    @RequestMapping("/secKill")
    public ModelAndView sk(Integer con_no) {
        String lockKey = "pro01";
        String clientId = con_no.toString();
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 2, TimeUnit.SECONDS);
            if (!result) {
                return new ModelAndView("redirect:secKillFail.html");
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("key"));

            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("key", realStock + "");
                System.out.println("扣减成功！库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足！");
                return new ModelAndView("redirect:secKillFail.html");
            }
        } finally {
            if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                stringRedisTemplate.delete(lockKey);
            }
        }
        ModelAndView modelAndView = new ModelAndView("redirect:secKillOrder.html");
        return modelAndView;
    }

    @RequestMapping("/testTest")
    public ModelAndView a() {

        ModelAndView modelAndView = new ModelAndView("redirect:secKillFail.html");
        return modelAndView;
    }


}
