package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.service.TTagService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 标签(TTag)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class TTagController {
    /**
     * 服务对象
     */
    @Reference
    TTagService tTagService;

    /**
     * 通过标签号获取标签名称
     *
     * @param
     * @return 单条数据
     */
    @ApiOperation(value = "获取单个标签名称")
    @ResponseBody
    @GetMapping("getTagName")
    public Result getTagName(Integer t_no){
        return setResultSuccess(this.tTagService.getTagName(t_no));
    }


    @ResponseBody
    @GetMapping("Fan/getAllTag")
    public Result getAllTag(){
        return setResultSuccess(tTagService.queryAll());
    }

}