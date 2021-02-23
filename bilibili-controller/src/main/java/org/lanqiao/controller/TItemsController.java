package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.service.TCollectionsService;
import org.lanqiao.service.TItemsService;
import org.lanqiao.util.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.controller
 * @ClassName:TItemsController
 * @Description:
 * @Date 2021/2/18 11:55
 */
@CrossOrigin
@Controller
public class TItemsController {

    @Reference
    TItemsService tItemsService;

    @ResponseBody
    @PostMapping("getAllItems")
    public Result queryAll() {
        return setResultSuccess(this.tItemsService.queryAll());
    }

    @ResponseBody
    @PostMapping("getItemName")
    public Result queryName(Integer i_no) {
        return setResultSuccess(this.tItemsService.queryName(i_no));
    }

    @ResponseBody
    @PostMapping("getItemMoney")
    public Result queryMoney(Integer i_no) {
        return setResultSuccess(this.tItemsService.queryMoney(i_no));
    }

}
