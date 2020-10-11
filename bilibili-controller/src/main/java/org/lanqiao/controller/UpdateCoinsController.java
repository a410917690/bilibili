package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.lanqiao.service.UpdateCoinsService;
import org.lanqiao.util.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.lanqiao.util.ResultFactory.setResultError;
import static org.lanqiao.util.ResultFactory.setResultSuccess;

@RestController
@CrossOrigin
public class UpdateCoinsController {
    @Reference
    UpdateCoinsService updateCoinsService;

    @ApiOperation(value = "投币接口")
    @ResponseBody
    @PostMapping("giveCoins")
    public Result giveCoins(Integer con_no, Integer v_no) {
        boolean falg = updateCoinsService.update(con_no, v_no);
        if (falg == true) {
            return setResultSuccess("投币成功！");
        } else {
            return setResultError(500,"投币失败，请检查余额！");
        }


    }
}
