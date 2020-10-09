package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TConsumers;

import org.lanqiao.service.TConsumersService;
import org.lanqiao.util.Result;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.lanqiao.util.ResultFactory.setResultError;
import static org.lanqiao.util.ResultFactory.setResultSuccess;

/**
 * 用户(ConsumersVo)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
public class TConsumersController {
    /**
     * 服务对象
     */
    @Reference
    TConsumersService tConsumersService;


    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @PostMapping("login")
    public Result selectOne(String name) {
        return setResultSuccess(tConsumersService.queryById(name));

        //return this.tConsumersService.queryById(name);
    }

    @ResponseBody
    @PostMapping("getAllConsumers")
    public Result getAllConsumersByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tConsumersService.getAllConsumersByPage(page,10));
    }

    @ResponseBody
    @PostMapping("getRoleName")
    public Result getRoleName(Integer con_no){
        return setResultSuccess(tConsumersService.getRoleName(con_no));
    }


    @ResponseBody
    @PostMapping("register")
    public Result isUser(String name,String password,String tel_num){
        TConsumers tConsumers= new TConsumers();
        tConsumers.setName(name);
        tConsumers.setTel_num(tel_num);
        tConsumers.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        List<TConsumers> list = this.tConsumersService.queryAll(tConsumers);
        if(list.isEmpty()){
            return setResultSuccess(tConsumersService.insert(tConsumers));

        }else {
            return setResultError(500,"注册失败");
        }
    }


    @ResponseBody
    @PostMapping("updateConsumers")
    public Result updateConsumers(TConsumers tConsumers){
        TConsumers tConsumers1 = tConsumersService.queryByCno(tConsumers.getCon_no());
        tConsumers1.setPassword(BCrypt.hashpw(tConsumers.getPassword(), BCrypt.gensalt()));
        tConsumers1.setCoins(tConsumers.getCoins());
        tConsumers1.setRole_no(tConsumers.getRole_no());
        tConsumers1.setMember_deadline(tConsumers.getMember_deadline());
        tConsumers1.setCon_is_legal(tConsumers.getCon_is_legal());
        tConsumers1.setTel_num(tConsumers.getTel_num());
        return setResultSuccess(tConsumersService.update(tConsumers1));
    }

    @ResponseBody
    @PostMapping("deleteConsumers")
    public Result deleteConsumers(Integer con_no){
        return setResultSuccess(tConsumersService.deleteById(con_no));
    }
}


