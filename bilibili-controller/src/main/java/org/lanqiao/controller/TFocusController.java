package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.entity.TFocus;
import org.lanqiao.service.TFocusService;
import org.lanqiao.util.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;


/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.controller
 * @ClassName:TFocusController
 * @Description:
 * @Date 2021/2/23 9:34
 */
@Controller
public class TFocusController {

    @Reference
    TFocusService tFocusService;


    @ApiOperation("关注")
    @ResponseBody
    @PostMapping("addFocus")
    public Result addFocus(Integer con_no, Integer fo_fo_no) {
        TFocus focus = tFocusService.isFocus(con_no,fo_fo_no);
        if (focus == null) {
            int i = tFocusService.addFocus(con_no, fo_fo_no);
            if (i > 0) {
                return setResultSuccess(200, "关注成功", i);
            }else {
                return setResultError(400, "关注失败", i);
            }
        }else{
            return setResultError(400, "已关注，请不要重复此操作！");
        }
    }


    @ApiOperation("取消关注")
    @ResponseBody
    @PostMapping("deleteFocus")
    public Result deleteFocus(Integer con_no, Integer fo_fo_no) {
        int i = tFocusService.deleteFocus(con_no, fo_fo_no);
        if(i>0) {
            return setResultSuccess(200, "取消关注成功", tFocusService.deleteFocus(con_no, fo_fo_no));
        }else {
            return setResultError(400, "取消关注失败", i);
        }
    }


    @ApiOperation("获取指定的关注用户信息")
    @ResponseBody
    @PostMapping("getFocus")
    public Result getFocus(Integer fo_fo_no) {
        TConsumers tConsumers = tFocusService.getFocus(fo_fo_no);
        if (tConsumers != null) {
            return setResultSuccess(200, "获取指定的关注用户成功", tFocusService.getFocus(fo_fo_no));
        }else {
            return setResultError(400, "获取指定的关注用户失败");
        }
    }


    @ApiOperation("获取所有关注用户")
    @ResponseBody
    @PostMapping("getAllFocusConsumerByCon")
    public Result getAllFocusConsumerByCon(Integer con_no) {
        return setResultSuccess(200,"获取所有关注用户成功",tFocusService.getAllFocusConsumerByCon(con_no));
    }


    @ApiOperation("获取被关注数")
    @ResponseBody
    @GetMapping("getNumBF")
    public Result getNumBF(Integer fo_fo_no){
        return setResultSuccess(200,"success",tFocusService.getNumBF(fo_fo_no));
    }


    @ApiOperation("获取关注数")
    @ResponseBody
    @GetMapping("getNumF")
    public Result getNumF(Integer fo_fo_no){
        return setResultSuccess(200,"success",tFocusService.getNumF(fo_fo_no));
    }


    @ApiOperation("获取被点赞数")
    @ResponseBody
    @GetMapping("getNumL")
    public Result getNumL(Integer fo_fo_no){
        return setResultSuccess(200,"success",tFocusService.getNumL(fo_fo_no));
    }

}
