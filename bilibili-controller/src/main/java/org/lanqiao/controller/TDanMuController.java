package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TDanMu;

import org.lanqiao.service.TDanMuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 弹幕(TDanMu)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
public class TDanMuController {
    /**
     * 服务对象
     */
    @Reference
    TDanMuService tDanMuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne6")
    public TDanMu selectOne(Integer id) {
        return this.tDanMuService.queryById(id);
    }

}