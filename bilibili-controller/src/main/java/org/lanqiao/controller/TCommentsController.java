package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TComments;

import org.lanqiao.service.TCommentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论(TComments)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController

public class TCommentsController {
    /**
     * 服务对象
     */
    @Reference
    TCommentsService tCommentsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne3")
    public TComments selectOne(Integer id) {
        return this.tCommentsService.queryById(id);
    }

}