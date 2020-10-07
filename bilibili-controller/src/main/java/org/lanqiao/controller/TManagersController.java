package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TManagers;

import org.lanqiao.service.TManagersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员(TManagers)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController

public class TManagersController {
    /**
     * 服务对象
     */
    @Reference
    TManagersService tManagersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne11")
    public TManagers selectOne(Integer id) {
        return this.tManagersService.queryById(id);
    }

}