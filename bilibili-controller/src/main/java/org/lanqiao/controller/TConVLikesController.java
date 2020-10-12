package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.models.auth.In;
import org.lanqiao.entity.TConVLikes;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.service.TConsumersService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.lanqiao.util.ResultFactory.setResultError;
import static org.lanqiao.util.ResultFactory.setResultSuccess;

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