package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TConsumers;

import org.lanqiao.service.TConsumersService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.jwt.JWT_HS256;
import org.lanqiao.util.jwt.JWT_RS256;
import org.lanqiao.util.result.Result;
import org.lanqiao.util.result.ResultFactory;
import org.lanqiao.vo.ConsumerCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 用户(ConsumersVo)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
//@Api(tags = "用户")
public class TConsumersController {
    /**
     * 服务对象
     */
    @Reference
    TConsumersService tConsumersService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Autowired
    RedisUtil redisUtil;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @Autowired
    JWT_HS256 jwt_hs256;

    @ApiOperation("账号密码登录")
    @ResponseBody
    @PostMapping("login")
    public Result selectOne(String name, String password) {
        TConsumers tConsumers = tConsumersService.queryByNameAndPwd(name, password);
        if (tConsumers != null) {
            //生成token,三种方法
            //第一种，UUID.randomUUID() + ""
            String token = UUID.randomUUID() + "";
            //第二种，利用JWT生成Token，用HS256对称算法加密
//            String token = jwt_hs256.buildJWT(tConsumers);
            // 第二种，利用JWT生成Token，用RS256对称算法加密
//            String token = JWT_RS256.buildToken(user);
            //将token和数据存入redis缓存中
            assert token != null;
            redisTemplate.opsForValue().set(token, tConsumers, Duration.ofSeconds(24 * 60 * 60));
//            response.addHeader("token",token);
            return ResultFactory.setResultSuccess(200, "登录成功", token);
        }
        return ResultFactory.setResultError(400, "登录失败");
    }


    @ApiOperation("验证码登录")
    @ResponseBody
    @PostMapping("loginByMail")
    public Result loginByMail(String mail, String code) {
        TConsumers tConsumers = tConsumersService.loginInByEmail(mail, code);
        if (tConsumers != null) {
            //生成token,三种方法
            //第一种，UUID.randomUUID() + ""
            String token = UUID.randomUUID() + "";
            //第二种，利用JWT生成Token，用HS256对称算法加密
//            String token = JWT_HS256.buildJWT(tConsumers);
            // 第二种，利用JWT生成Token，用RS256对称算法加密
//            String token = JWT_RS256.buildToken(user);
            //将token和数据存入redis缓存中
            assert token != null;
            redisTemplate.opsForValue().set(token, tConsumers, Duration.ofSeconds(24 * 60 * 60));
            return setResultSuccess(200, "登录成功", token);
        } else {
            return setResultSuccess(400, "登录失败");
        }
    }



    @ApiOperation("通过token获取用户信息")
    @ResponseBody
    @PostMapping("getConByToken")
    public Result getConByToken(String token) {
        Object user = redisTemplate.opsForValue().get(token);
        if (user != null) {
            return setResultSuccess(200, "获取用户成功", user);
        } else {
            return setResultError(400, "获取用户成功", null);
        }
    }

    @ApiOperation("获取所有用户")
    @ResponseBody
    @PostMapping("getAllConsumers")
    public Result getAllConsumersByPage(@RequestParam(defaultValue = "1") int page) {
        return setResultSuccess(tConsumersService.getAllConsumersByPage(page, 10));
    }

    @ApiOperation("通过<唯一字段>用户名获取用户信息")
    @ResponseBody
    @PostMapping("getConsumersByName")
    public Result getConsumersByName(String name) {
        return setResultSuccess(tConsumersService.queryByName(name));
    }

    @ApiOperation("通过用户id获取用户信息")
    @ResponseBody
    @PostMapping("getConsumersByNo")
    public Result getConsumersByNo(Integer con_no) {
        return setResultSuccess(tConsumersService.queryByCno(con_no));
    }


    @ApiOperation("通过用户id获取角色名称")
    @ResponseBody
    @PostMapping("getRoleName")
    public Result getRoleName(Integer con_no) {
        return setResultSuccess(tConsumersService.getRoleName(con_no));
    }


    @ApiOperation("验证码注册")
    @ResponseBody
    @PostMapping("Fan/register")
    public Result isUser(ConsumerCodeVo consumerCodeVo) {
        boolean flag;
        flag = this.tConsumersService.registered(consumerCodeVo);
        if (flag) {
            return setResultSuccess(200, "注册成功");
        } else {
            return setResultError(400, "注册失败");
        }
    }

    @ApiOperation("修改用户信息")
    @ResponseBody
    @PostMapping("updateConsumers")
    public Result updateConsumers(TConsumers tConsumers) {
        TConsumers tConsumers1 = tConsumersService.queryByCno(tConsumers.getCon_no());
        tConsumers1.setPassword(tConsumers.getPassword());
        tConsumers1.setCoins(tConsumers.getCoins());
        tConsumers1.setRole_no(tConsumers.getRole_no());
        tConsumers1.setMember_deadline(tConsumers.getMember_deadline());
        tConsumers1.setCon_is_legal(tConsumers.getCon_is_legal());
        tConsumers1.setTel_num(tConsumers.getTel_num());
        return setResultSuccess(tConsumersService.update(tConsumers1));
    }

    @ApiOperation("通过用户id删除用户")
    @ResponseBody
    @PostMapping("deleteConsumers")
    public Result deleteConsumers(Integer con_no) {
        return setResultSuccess(tConsumersService.deleteById(con_no));
    }

    @ApiOperation("发送验证码")
    @PostMapping("/send")
    @ResponseBody
    public Result sendEmail(String mail) {
        boolean flag;
        flag = tConsumersService.sendMimeMail(mail);
        return setResultSuccess(200, "验证码发送成功", flag);
    }

    @ApiOperation("通过用户名获取密码<验证码验证>")
    @PostMapping("/findPwd")
    @ResponseBody
    public Result findPwd(String name, String mail, String code) {
        String password = tConsumersService.findPwd(name, mail, code);
        if (!"".equals(password)) {
            return setResultSuccess(200, password);
        }
        return setResultError(400, "fail");
    }

    @ApiOperation("更新密码")
    @PostMapping("/updatePwd")
    @ResponseBody
    public Result updatePwd(String name, String password) {
        Integer res = tConsumersService.updatePwd(name, password);
        if (res != 0) {
            return setResultSuccess(200, "success", res);
        }
        return setResultError(400, "fail");
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/updateDetail")
    @ResponseBody
    public Result updateDetail(String newName, String name, String tele_num, Integer age, String password, String newPwd, String confirmPwd) {
        Integer res = tConsumersService.updateDetail(newName, name, tele_num, age, password, newPwd, confirmPwd);
        if (res != 0) {
            return setResultSuccess(200, "success", res);
        }
        return setResultError(400, "fail");
    }

    @ApiOperation("上传图片")
    @ResponseBody
    @PostMapping("/uploadPic")
    public Result savePic(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        byte[] pic = null;
        if (file != null) {
            try {
                //MultipartFile转InputStream
                InputStream inputStream = file.getInputStream();

                pic = new byte[inputStream.available()];
                inputStream.read(pic);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return setResultError();
        }
        tConsumersService.uploadPic(pic, name);

        return setResultSuccess(200, "上传图片成功", pic);
    }

    @ApiOperation("通过用户id获取用户头像")
    @ResponseBody
    @GetMapping(value = "/getPhoto")
    public Result getPhotoById(final HttpServletResponse response, Integer con_no) throws IOException {
        TConsumers users = tConsumersService.queryByCno(con_no);
        byte[] data = users.getPic();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(data);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputSream.write(buf, 0, len);
        }
        outputSream.close();
        return setResultSuccess(200, "获取图片成功", buf);
    }

    @ApiOperation("用户举报")
    @ResponseBody
    @PostMapping(value = "/conReport")
    public Result report(Integer con_no) {
        int report = tConsumersService.report(con_no);
        if (report > 0) {
            return setResultSuccess(200, "举报成功", report);
        } else {
            return setResultError(400, "举报失败", report);
        }
    }

    @ApiOperation("用户账号异常")
    @ResponseBody
    @PostMapping(value = "/conToIllegal")
    public Result toIllegal(Integer con_no) {
        int i = tConsumersService.toIllegal(con_no);
        if (i > 0) {
            return setResultSuccess(200, "账号异常，已被冻结", i);
        } else {
            return setResultError(400, "我们会持续监控该用户的操作", i);
        }
    }

    @ApiOperation("会员到期检测")
    @ResponseBody
    @PostMapping(value = "/decrMemberDeadline")
    public Result decrMemberDeadline(Integer con_no) {
        int i = tConsumersService.decrMemberDeadline(con_no);
        return setResultSuccess(200, "success",i);
    }

}


