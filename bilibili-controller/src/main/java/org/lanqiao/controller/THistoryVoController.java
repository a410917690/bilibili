package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.service.THistoryVoService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.lanqiao.util.result.ResultFactory.setResultSuccess;


@RestController
@CrossOrigin
public class THistoryVoController {

    @Reference
    THistoryVoService tHistoryVoService;

    @ResponseBody
    @PostMapping("getHistory")
    public Result getHistory(Integer con_no){
        return setResultSuccess(tHistoryVoService.getHistory(con_no));
    }
}
