package org.lanqiao.service;

import org.lanqiao.entity.TLiveRooms;

import java.util.List;

/**
 * 直播间(TLiveRooms)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TLiveRoomsService {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    TLiveRooms queryById(Integer room_no);

    Object queryAllByPage(int pageNum,int pageSize);

    /**
     * 获取所有直播间
     *
     */
    List<TLiveRooms> getAllLives();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TLiveRooms> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tLiveRooms 实例对象
     * @return 实例对象
     */
    boolean insert(TLiveRooms tLiveRooms);

    /**
     * 修改数据
     *
     * @param tLiveRooms 实例对象
     * @return 实例对象
     */
    TLiveRooms update(TLiveRooms tLiveRooms);

    /**
     * 通过主键删除数据
     *
     * @param roomNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roomNo);

    /**
     * 关闭直播间
     */
    boolean closeLive(Integer room_no);

    /**
     * 举报直播间
     */
    boolean updateReportRoom(Integer con_no,Integer room_no,String reason);

    /**
     * 给当前直播间点赞
     */
    boolean likeRoom(Integer con_no,Integer room_no);

    /**
     * 是否已给当前直播间点过赞
     */
    boolean isLikeRoom(Integer con_no,Integer room_no);
}