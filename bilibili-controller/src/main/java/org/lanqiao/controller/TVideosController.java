package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;


import static org.lanqiao.util.ResultFactory.setResultError;
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

    @Reference
    TConVLikesService tConVLikesService;

//    @Resource
//    TVideos tVideos;

    @Autowired
    RedisUtil redisUtil;


    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("Fan/getOneVideos")
    public Result selectOne(Integer v_no) {
        return setResultSuccess(tVideosService.queryById(v_no));
    }


    @ResponseBody
    @GetMapping("Fan/getAllVideos")
    public Result getAllVideosByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tVideosService.getAllVideosByPage(page,6));
    }

    @ResponseBody
    @GetMapping("Fan/getVideosByTag")
    public Result getVideosByTag(@RequestParam(defaultValue = "1")int page,int t_no){
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

//    @ResponseBody
//    @PostMapping("Like")
//    public Result likeVideo(TVideos tVideos){
//        tVideosService.LikesVideos(tVideos);
//         redisUtil.incr(tVideos.getV_likes(),1);
//    }
    @ResponseBody
    @PostMapping("giveLike")
    public Result giveLike(@RequestParam("con_no") Integer con_no ,@RequestParam("v_no") Integer v_no){

        boolean falg = tConVLikesService.queryByVnoCno(con_no,v_no);
        if (falg ==true) {
            redisUtil.incr("v_likes"+v_no,1);
            tConVLikesService.insert(con_no,v_no);
            return setResultSuccess("点赞成功！");
        }else {
            return setResultError(500,"点赞失败！");
        }
    }

    @ResponseBody
    @PostMapping("getLikesNum")
    public Result giveLikesNum(Integer v_no){
        int num =(int)redisUtil.get("v_likes"+v_no);
        tVideosService.updateLikeNum(num,v_no);
        return setResultSuccess(redisUtil.get("v_likes"+v_no));
    }

}