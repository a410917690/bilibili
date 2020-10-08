package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TConsumers;

import org.lanqiao.service.TConsumersService;
import org.springframework.web.bind.annotation.*;

/**
 * 用户(ConsumersVo)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController

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

}