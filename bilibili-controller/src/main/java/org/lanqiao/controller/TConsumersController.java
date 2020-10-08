package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TConsumers;

import org.lanqiao.service.TConsumersService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
    public TConsumers selectOne(String name) {
        return this.tConsumersService.queryById(name);
    }

    @ResponseBody
    @PostMapping("getAllConsumers")
    public Object getAllConsumersByPage(@RequestParam(defaultValue = "1")int page){
        return tConsumersService.getAllConsumersByPage(page,10);
    }

    @ResponseBody
    @PostMapping("getRoleName")
    public String getRoleName(Integer con_no){
        return this.tConsumersService.getRoleName(con_no);
    }


    @ResponseBody
    @PostMapping("register")
    public boolean isUser(String name,String password,String tel_num){
        TConsumers tConsumers= new TConsumers();
        tConsumers.setName(name);
        tConsumers.setTel_num(tel_num);
        tConsumers.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        List<TConsumers> list = this.tConsumersService.queryAll(tConsumers);
        if(list.isEmpty()){
            this.tConsumersService.insert(tConsumers);
            return  true;
        }else {
            return false;
        }
    }


    @ResponseBody
    @PostMapping("updateConsumers")
    public String updateConsumers(String tel_num,String password){
        TConsumers tConsumers = this.tConsumersService.queryByTel(tel_num);
        tConsumers.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        this.tConsumersService.update(tConsumers);
        return "修改成功！";
    }
}


