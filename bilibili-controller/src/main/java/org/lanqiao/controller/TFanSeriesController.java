package org.lanqiao.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TFanSeries;
import org.lanqiao.service.TFanSeriesService;
import org.lanqiao.util.result.Result;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;



import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 剧集(TFanSeries)表控制层
 *
 * @author makejava
 * @since 2020-10-09 19:10:09
 */
@RestController
@CrossOrigin
public class TFanSeriesController {
    /**
     * 服务对象
     */
    @Reference
    private TFanSeriesService tFanSeriesService;

    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("Fan/getOneSeriesFan")
    public Result getOneSeriesFan(Integer fan_series_no){
        return setResultSuccess(tFanSeriesService.queryById(fan_series_no));
    }



    @ApiOperation(value = "获取番剧所有剧集（不分页）")
    @ResponseBody
    @GetMapping("getFanSeries")
    public Result getFanSeries(Integer fan_no){
        return setResultSuccess(tFanSeriesService.getFanSeries(fan_no));
    }

    @ResponseBody
    @GetMapping("Fan/getSeriesFan")
    public Result querySeries(@RequestParam(defaultValue = "1")int page, Integer fan_no) {
         return setResultSuccess(tFanSeriesService.querySeries(page,4,fan_no));
    }

    @ResponseBody
    @PostMapping("updateSeriesFan")
    public Result updateSeriesFan(TFanSeries tFanSeries){
        return setResultSuccess(tFanSeriesService.update(tFanSeries));
    }

    @ResponseBody
    @PostMapping("deleteSeriesFan")
    public  Result deleteSeriesFan(Integer fan_series_no){
        return setResultSuccess(tFanSeriesService.deleteById(fan_series_no));
    }




}