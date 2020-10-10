package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TVideosService;
import org.lanqiao.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.lanqiao.util.ResultFactory.setResultSuccess;

/**
 * 视频(TVideos)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@Controller
@CrossOrigin
public class TVideosController {
    /**
     * 服务对象
     */
    @Reference
    TVideosService tVideosService;

    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("getOneVideos")
    public Result selectOne(Integer v_no) {
        return setResultSuccess(tVideosService.queryById(v_no));
    }


    @ResponseBody
    @GetMapping("getAllVideos")
    public Result getAllVideosByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tVideosService.getAllVideosByPage(page,6));
    }

    @ResponseBody
    @GetMapping("getVideosByTag")
    public Result getVideosByTag(@RequestParam(defaultValue = "1")int page,@RequestParam("t_no")int t_no){
        return setResultSuccess(tVideosService.getVideosByTag(page,6,t_no));
    }


    @ResponseBody
    @PostMapping("updateVideos")
    public Result update(TVideos tVideos){
        return setResultSuccess(tVideosService.update(tVideos));
    }
//
//    @ResponseBody
//    @PostMapping("update")


    @ResponseBody
    @PostMapping("deleteVideos")
    public Result delete(Integer v_no){
        return setResultSuccess(tVideosService.deleteById(v_no));
    }



}