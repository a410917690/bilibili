package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.THistory;

import org.lanqiao.service.THistoryService;
import org.lanqiao.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.lanqiao.util.ResultFactory.setResultSuccess;

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

//    @ResponseBody
//    @PostMapping("getHistory")
//    public Result getHistory(Integer con_no){
//        return setResultSuccess(tHistoryService.queryAllHisByCon(con_no));
//
//    }

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