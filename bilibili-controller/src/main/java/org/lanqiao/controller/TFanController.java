package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TFan;

import org.lanqiao.service.TFanService;
import org.springframework.web.bind.annotation.*;

/**
 * 番剧(TFan)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
public class TFanController {
    /**
     * 服务对象
     */
    @Reference
   TFanService tFanService;

    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("getOneFan")
    public TFan selectOne(String fan_title) {
        return this.tFanService.queryById(fan_title);
    }

    @ResponseBody
    @GetMapping("getAllFan")
    public Object queryAllFanByPage(@RequestParam(defaultValue = "1")int page){
        return tFanService.queryAllByPage(page,6);
    }

}