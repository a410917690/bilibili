package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import io.swagger.annotations.ApiOperation;
import org.lanqiao.service.THistoryService;
import org.lanqiao.service.THistoryVoService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.text.ParseException;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 观看历史(THistory)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class THistoryController {
    /**
     * 服务对象
     */
    @Reference
   THistoryService tHistoryService;



    @ApiOperation(value = "获取当前用户的观看记录")
    @ResponseBody
    @GetMapping("getHistory")
    public Result getHistory(Integer con_no){
        try {
            return setResultSuccess(tHistoryService.getHistory(con_no));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return setResultError(500,"数据输入错误");

    }


    @ApiOperation(value = "删除观看记录")
    @ResponseBody
    @PostMapping("deleteHistory")
    public Result deleteHistory(@RequestParam("con_no") Integer con_no,@RequestParam("v_no") Integer v_no){
        return setResultSuccess(tHistoryService.deleteById(con_no,v_no));
    }

    @ResponseBody
    @PostMapping("insertHistory")
    public Result insertHistory(@RequestParam("con_no") Integer con_no,@RequestParam("v_no") Integer v_no){


        return setResultSuccess(tHistoryService.insert(con_no,v_no));
    }
}