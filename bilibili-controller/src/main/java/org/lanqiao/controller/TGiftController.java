package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TGift;
import org.lanqiao.service.TGiftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 礼物(TGift)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController

public class TGiftController {
    /**
     * 服务对象
     */
    @Reference
    TGiftService tGiftService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @GetMapping("selectOne8")
    public TGift selectOne(Integer id) {
        return this.tGiftService.queryById(id);
    }

    @ResponseBody
    @GetMapping("getAllGit")
    public List<TGift> queryAll(){
        return this.tGiftService.queryAll();
    }
}