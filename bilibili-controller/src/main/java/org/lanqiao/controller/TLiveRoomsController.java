package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.lanqiao.service.TLiveRoomsService;
import org.lanqiao.util.result.Result;
import org.springframework.web.bind.annotation.*;

import static org.lanqiao.util.result.ResultFactory.setResultError;
import static org.lanqiao.util.result.ResultFactory.setResultSuccess;

/**
 * 直播间(TLiveRooms)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class TLiveRoomsController {
    /**
     * 服务对象
     */
    @Reference
    TLiveRoomsService tLiveRoomsService;

    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("Fan/getOneRoom")
    public Result selectOne(Integer room_no) {
        return setResultSuccess(tLiveRoomsService.queryById(room_no));
    }


    @ResponseBody
    @GetMapping("Fan/getAllRoom")
    public Result getAllRoomByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tLiveRoomsService.queryAllByPage(page,6));
    }

    @ApiOperation(value = "获取所有直播间信息")
    @ResponseBody
    @GetMapping("getAllLives")
    public Result getAllLives(){
        return setResultSuccess(tLiveRoomsService.getAllLives());
    }

    @ApiOperation(value = "主播下播（修改直播间状态为0）")
    @ResponseBody
    @GetMapping("closeLive")
    public Result closeLive(Integer room_no){
        if (this.tLiveRoomsService.closeLive(room_no)) {
            return setResultSuccess();
        }else {
            return setResultError(500,"直播间无法关停");
        }
    }
}