package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TVideosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

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
    public TVideos selectOne(Integer v_no) {
        return this.tVideosService.queryById(v_no);
    }


//    @ResponseBody
//    @GetMapping("getAllVideos")
//    public List<TVideos> getAllVideos(@RequestParam(defaultValue = "1") int pageNum , Model model){
//        PageHelper.startPage(pageNum,2);
//        List<TVideos> list = tVideosService.queryAll();
//        PageInfo<TVideos> pageInfo = new PageInfo<>(list);
//        model.addAttribute("pageInfo",pageInfo);
//        return list;
//    }

    @ResponseBody
    @GetMapping("getAllVideos")
    public Object getAllVideosByPage(@RequestParam(defaultValue = "1")int page){
        return tVideosService.getAllVideosByPage(page,6);
    }

    @ResponseBody
    @GetMapping("getVideosByTag")
    public Object getVideosByTag(@RequestParam(defaultValue = "1")int page,@RequestParam("t_no")int t_no){
        return tVideosService.getVideosByTag(page,6,t_no);
    }


    @ResponseBody
    @GetMapping("updateVideos")
    public TVideos update(TVideos tVideos){
        return this.tVideosService.update(tVideos);

    }



}