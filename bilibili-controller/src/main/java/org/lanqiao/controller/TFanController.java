package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TFan;

import org.lanqiao.service.TFanService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

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
    @GetMapping("Fan/getOneFan")
    public Result selectOne(Integer fan_no) {
        return setResultSuccess(tFanService.queryById(fan_no));
    }

    @ResponseBody
    @GetMapping("Fan/getAllFan")
    public Result queryAllFanByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tFanService.queryAllByPage(page,6));
    }

    @ApiOperation(value = "获取所有番剧（不分页）")
    @ResponseBody
    @GetMapping("getAllFan")
    public Result getAllFan(){
        return setResultSuccess(tFanService.getAllFan());
    }

    @ResponseBody
    @PostMapping("updateFan")
    public Result updateFan(TFan tFan){
        return setResultSuccess(tFanService.update(tFan));
    }

    @ResponseBody
    @PostMapping("deleteFan")
    public Result deleteFan(Integer fan_no){
        return setResultSuccess(tFanService.deleteById(fan_no));
    }

}