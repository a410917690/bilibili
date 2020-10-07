package org.lanqiao.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TCollections;
import org.lanqiao.service.TCollectionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 收藏(TCollections)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:04
 */
@Controller
public class TCollectionsController {
    /**
     * 服务对象
     */
    @Reference
    TCollectionsService tCollectionsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("selectOne1")
    public TCollections selectOne(Integer id) {
         return this.tCollectionsService.queryById(1);
    }

}