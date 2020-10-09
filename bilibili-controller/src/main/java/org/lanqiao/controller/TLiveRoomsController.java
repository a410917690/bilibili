package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TLiveRooms;

import org.lanqiao.service.TLiveRoomsService;
import org.lanqiao.util.Result;
import org.springframework.web.bind.annotation.*;

import static org.lanqiao.util.ResultFactory.setResultSuccess;

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
    @GetMapping("getOneRoom")
    public Result selectOne(Integer room_no) {
        return setResultSuccess(tLiveRoomsService.queryById(room_no));
    }


    @ResponseBody
    @GetMapping("getAllRoom")
    public Result getAllRoomByPage(@RequestParam(defaultValue = "1")int page){
        return setResultSuccess(tLiveRoomsService.queryAllByPage(page,6));
    }
}