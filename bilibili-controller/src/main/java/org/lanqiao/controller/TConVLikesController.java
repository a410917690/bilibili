package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 用户点赞过 的视频(TConVLikes)表控制层
 *
 * @author makejava
 * @since 2020-10-11 15:38:21
 */
@RestController
@CrossOrigin
public class TConVLikesController {
    @Reference
    TConVLikesService tConVLikesService;


    @ApiOperation(value = "获取用户点赞的所有视频")
    @ResponseBody
    @GetMapping("getConVLikes")
    public Result getConVLikes(Integer con_no){
        return setResultSuccess(this.tConVLikesService.queryByCno(con_no));
    }







    @ResponseBody
    @PostMapping("isLike")
    public Result likeVideo(@RequestParam("con_no") Integer con_no,@RequestParam("v_no") Integer v_no){
        boolean falg = tConVLikesService.queryByVnoCno(con_no,v_no);
        if (falg == true) {
            return setResultSuccess("可以点赞！");
        } else {
            return setResultError(500, "无法重复点赞！");
        }


    }

}