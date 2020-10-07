package org.lanqiao.service;

import org.lanqiao.entity.TRoomGift;

import java.util.List;

/**
 * 直播间收到的用户礼物(TRoomGift)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TRoomGiftService {

    /**
     * 通过ID查询单条数据
     *
     * @param roomGNo 主键
     * @return 实例对象
     */
    TRoomGift queryById(Integer roomGNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoomGift> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tRoomGift 实例对象
     * @return 实例对象
     */
    TRoomGift insert(TRoomGift tRoomGift);

    /**
     * 修改数据
     *
     * @param tRoomGift 实例对象
     * @return 实例对象
     */
    TRoomGift update(TRoomGift tRoomGift);

    /**
     * 通过主键删除数据
     *
     * @param roomGNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roomGNo);

}