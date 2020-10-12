package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TComComment;
import org.lanqiao.service.TComCommentService;
import org.lanqiao.util.Result;
import org.lanqiao.vo.TCommentVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.lanqiao.util.ResultFactory.setResultError;
import static org.lanqiao.util.ResultFactory.setResultSuccess;

/**
 * 评论的评论(TComComment)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:06
 */
@RestController
@CrossOrigin
public class TComCommentController {
    /**
     * 服务对象
     */
    @Reference
     TComCommentService tComCommentService;

    @ApiOperation("获取对评论的回复集合 ")
    @ResponseBody
    @PostMapping("getComReply")
    public Result getComReply(@RequestParam("v_no")Integer v_no,@RequestParam("con_no") Integer con_no){
        return setResultSuccess(tComCommentService.getComReply(v_no,con_no));
    }

    @ApiOperation("得到评论编号")
    @ResponseBody
    @PostMapping("getComNo")
    public Result getComNo(@RequestParam("v_no")Integer v_no,@RequestParam("con_no") Integer con_no){
        return setResultSuccess(tComCommentService.queryComNo(v_no,con_no));
    }

    @ApiOperation("对评论进行回复")
    @ResponseBody
    @PostMapping("insertComReply")
    public Result insertComReply(@RequestParam("com_com")String com_com,@RequestParam("con_no") Integer con_no,@RequestParam("com_no")Integer com_no){

        if (tComCommentService.insert(com_com,con_no,com_no)== true) {
            return setResultSuccess("插入成功！");
        }else {
            return setResultError(500,"插入失败");
        }
    }


}