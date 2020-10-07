package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TLiveRooms;

import org.lanqiao.service.TLiveRoomsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直播间(TLiveRooms)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController

public class TLiveRoomsController {
    /**
     * 服务对象
     */
    @Reference
    TLiveRoomsService tLiveRoomsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne0")
    public TLiveRooms selectOne(Integer id) {
        return this.tLiveRoomsService.queryById(id);
    }

}