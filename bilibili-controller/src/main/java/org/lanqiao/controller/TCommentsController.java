package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TComments;

import org.lanqiao.service.TCommentsService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import static org.lanqiao.util.result.ResultFactory.setResultSuccess;


/**
 * 评论(TComments)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
public class TCommentsController {
    /**
     * 服务对象
     */
    @Reference
    TCommentsService tCommentsService;


    @ResponseBody
    @PostMapping("getCommentsByVno")
    public Result queryAllByVno(@RequestParam(defaultValue = "1")int page, Integer v_no){
        return setResultSuccess(tCommentsService.queryAllByVno(page,10,v_no));
    }

    @ResponseBody
    @PostMapping("insertComment")
    public Result insertComment(TComments tComments){
        return setResultSuccess(tCommentsService.insert(tComments));

    }

    @ResponseBody
    @PostMapping("deleteComment")
    public Result deleteComment(@RequestParam("v_no")Integer v_no,@RequestParam("con_no") Integer con_no){
        return setResultSuccess(tCommentsService.deleteComment(v_no,con_no));

    }


}