package org.lanqiao.service;

import org.lanqiao.entity.TRoomCon;

import java.util.List;

/**
 * 来到直播间的用户(TRoomCon)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TRoomConService {

    /**
     * 通过ID查询单条数据
     *
     * @param roomConNo 主键
     * @return 实例对象
     */
    TRoomCon queryById(Integer roomConNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoomCon> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tRoomCon 实例对象
     * @return 实例对象
     */
    TRoomCon insert(TRoomCon tRoomCon);

    /**
     * 修改数据
     *
     * @param tRoomCon 实例对象
     * @return 实例对象
     */
    TRoomCon update(TRoomCon tRoomCon);

    /**
     * 通过主键删除数据
     *
     * @param roomConNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roomConNo);

}