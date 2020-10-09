package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TComments;

import org.lanqiao.service.TCommentsService;
import org.springframework.web.bind.annotation.*;


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
    public Object queryAllByVno(@RequestParam(defaultValue = "1")int page,Integer v_no){
        return tCommentsService.queryAllByVno(page,10,v_no);
    }

    @ResponseBody
    @PostMapping("insertComment")
    public String insertComment(TComments tComments){
        tCommentsService.insert(tComments);
        return "添加成功!";
    }

    @ResponseBody
    @PostMapping("deleteComment")
    public String deleteComment(@RequestParam("v_no")Integer v_no,@RequestParam("con_no") Integer con_no){
        tCommentsService.deleteComment(v_no,con_no);
        return "删除成功！";
    }


}