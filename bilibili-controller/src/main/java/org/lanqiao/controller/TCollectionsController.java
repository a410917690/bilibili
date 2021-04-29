package org.lanqiao.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.service.TCollectionsService;
import org.lanqiao.util.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 收藏(TCollections)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:04
 */
@Controller
@CrossOrigin
public class TCollectionsController {
    /**
     * 服务对象
     */
    @Reference
    TCollectionsService tCollectionsService;

    @ApiOperation(value = "获取当前用户收藏的所有视频")
    @ResponseBody
    @GetMapping("getCollections")
    public Result getCollections(@RequestParam("con_no") Integer con_no,@RequestParam(defaultValue = "1") int pageNum) {
        return setResultSuccess(this.tCollectionsService.queryByCno(con_no,pageNum,9));
    }

    @ApiOperation(value = "获取当前用户收藏的视频（不分页）")
    @ResponseBody
    @GetMapping("getCollectionsNotPage")
    public Result getCollectionsNotPage(Integer con_no){
        return setResultSuccess(this.tCollectionsService.queryAllCollections(con_no));

    }




    @ApiOperation(value = "收藏视频")
    @ResponseBody
    @PostMapping("insertCollections")
    public Result insertCollections(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {
        List list = tCollectionsService.getVno(con_no);
        if (!list.contains(v_no)) {
            this.tCollectionsService.insert(con_no, v_no);
            return setResultSuccess("收藏成功！");
        }else {
            return setResultError(500,"请求失败，请检查参数！");
        }
    }

    @ResponseBody
    @PostMapping("isCollections")
    public Result isCollections(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {
        List list = tCollectionsService.getVno(con_no);
        if (list.contains(v_no)) {
            return setResultSuccess(true);
        }else {
            return setResultError(500,"您已收藏过该视频");
        }
    }

    @ApiOperation(value = "取消收藏")
    @ResponseBody
    @PostMapping("deleteCollections")
    public Result deleteCollections(@RequestParam("con_no") Integer con_no, @RequestParam("v_no") Integer v_no) {
        if (this.tCollectionsService.delete(con_no, v_no)) {
            return setResultSuccess("取消收藏成功！");
        } else {
            return setResultError(500,"请求失败，请检查参数！");
        }
    }


}