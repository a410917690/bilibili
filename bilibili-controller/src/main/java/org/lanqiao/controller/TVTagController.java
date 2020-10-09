package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TVTag;

import org.lanqiao.service.TVTagService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频标签(TVTag)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:10
 */
@RestController
@CrossOrigin
public class TVTagController {
    /**
     * 服务对象
     */
    @Reference
    TVTagService tVTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne17")
    public TVTag selectOne(Integer id) {
        return this.tVTagService.queryById(id);
    }

}