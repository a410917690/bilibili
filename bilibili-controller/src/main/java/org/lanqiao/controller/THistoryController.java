package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.THistory;

import org.lanqiao.service.THistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 观看历史(THistory)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController

public class THistoryController {
    /**
     * 服务对象
     */
    @Reference
   THistoryService tHistoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne9")
    public THistory selectOne(Integer id) {
        return this.tHistoryService.queryById(id);
    }

}