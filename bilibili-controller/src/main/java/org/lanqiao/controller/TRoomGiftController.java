package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TRoomGift;
import org.lanqiao.service.TRoomGiftService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直播间收到的用户礼物(TRoomGift)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class TRoomGiftController {
    /**
     * 服务对象
     */
    @Reference
    TRoomGiftService tRoomGiftService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne14")
    public TRoomGift selectOne(Integer id) {
        return this.tRoomGiftService.queryById(id);
    }

}