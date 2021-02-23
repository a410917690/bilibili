package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TDanMu;

import org.lanqiao.service.TDanMuService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 弹幕(TDanMu)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:08
 */
@RestController
@CrossOrigin
public class TDanMuController {
    /**
     * 服务对象
     */
    @Reference
    TDanMuService tDanMuService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("Fan/getDanMu")
    public List<TDanMu> getDanMu(Integer v_no){
        return tDanMuService.queryAll(v_no);
    }

    @ResponseBody
    @PostMapping("insertDanMu")
    public Result insertDanMu(TDanMu tDanMu){
        boolean falg =this.tDanMuService.insert(tDanMu);
        if (falg ==true){
            return setResultSuccess("发送成功！");
        }else {
            return setResultError(500,"发送失败！");
        }

    }



}