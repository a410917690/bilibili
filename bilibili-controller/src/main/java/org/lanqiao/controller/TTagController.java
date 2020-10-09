package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TTag;
import org.lanqiao.service.TTagService;
import org.lanqiao.util.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.lanqiao.util.ResultFactory.setResultSuccess;

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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne15")
    public TTag selectOne(Integer id) {
        return this.tTagService.queryById(id);
    }

    @ResponseBody
    @GetMapping("getAllTag")
    public Result getAllTag(){
        return setResultSuccess(tTagService.queryAll());
    }

}