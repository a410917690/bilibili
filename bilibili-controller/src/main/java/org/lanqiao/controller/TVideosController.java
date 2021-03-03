package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

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
     * 获取单个视频信息
     *
     * @return 单条数据
     */
    @ApiOperation(value = "获取单个视频信息")
    @ResponseBody
    @GetMapping("getOneVideos")
    public Result selectOne(Integer v_no) {
        return setResultSuccess(tVideosService.queryById(v_no));
    }


    /**
     * 获取所有视频
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "获取所有视频")
    @ResponseBody
    @GetMapping("getAllVideos")
    public Result getAllVideosByPage(@RequestParam(defaultValue = "1") int page) {
        return setResultSuccess(tVideosService.getAllVideosByPage(page, 6));
    }

    /**
     * 通过标签获取其下的所有视频
     *
     * @param page
     * @param t_no
     * @return
     */
    @ApiOperation(value = "通过标签获取其下的所有视频")
    @ResponseBody
    @GetMapping("getVideosByTag")
    public Result getVideosByTag(@RequestParam(defaultValue = "1") int page, int t_no) {
        return setResultSuccess(tVideosService.getVideosByTag(page, 6, t_no));
    }

    /**
     * 修改视频信息
     *
     * @param tVideos
     * @return
     */
    @ApiOperation(value = "修改视频信息")
    @ResponseBody
    @PostMapping("updateVideos")
    public Result update(TVideos tVideos) {
        return setResultSuccess(tVideosService.update(tVideos));
    }

    /**
     * 删除视频
     *
     * @param v_no
     * @return
     */
    @ApiOperation(value = "删除视频")
    @ResponseBody
    @PostMapping("deleteVideos")
    public Result delete(Integer v_no) {
        return setResultSuccess(tVideosService.deleteById(v_no));
    }

    /**
     * 给视频点赞
     *
     * @param con_no
     * @param v_no
     * @return
     */
    @ApiOperation("点赞视频")
    @ResponseBody
    @PostMapping("giveLike")
    public Result giveLike(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {

//        boolean flag = tConVLikesService.queryByVnoCno(con_no,v_no);
//        if (flag ==true) {
//            redisUtil.incr("v_likes"+v_no,1);
//            tConVLikesService.insert(con_no,v_no);
//            return setResultSuccess("点赞成功！");
//        }else {
//            return setResultError(400,"点赞失败！");
//        }
        boolean flag = tConVLikesService.queryByVnoCno(con_no, v_no);
        if (flag == true) {
            if (this.tVideosService.updateLikeNum(v_no) > 0 && this.tConVLikesService.insert(con_no, v_no)) {
                int like = tVideosService.getLike(v_no);
                return setResultSuccess(200,"点赞成功！",like);
            } else {
                return setResultError(400, "点赞失败,您已给该视频点过赞了！");
            }
        } else {
            return setResultError(400, "点赞失败,您已给该视频点过赞了！");
        }
    }

    /**
     * 举报视频
     */
    @ApiOperation(value = "举报视频")
    @ResponseBody
    @GetMapping("reportVideo")
    public Result reportVideo(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {
        if (this.tVideosService.updateReportVideo(con_no, v_no) == true) {
            return setResultSuccess("举报成功！");
        } else {
            return setResultError(400, "举报失败，您已举报过该视频!");
        }
    }

//
//    /**
//     * 获取视频的点赞数
//     * @param v_no
//     * @return
//     */
//    @ResponseBody
//    @PostMapping("getLikesNum")
//    public Result getLikesNum(Integer v_no){
//        return setResultSuccess(200,"获取点赞数");
//    }

}