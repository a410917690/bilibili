package org.lanqiao.service;

import org.lanqiao.entity.TConGift;

import java.util.List;

/**
 * 用户礼物(TConGift)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:28
 */
public interface TConGiftService {

    /**
     * 通过ID查询单条数据
     *
     * @param conGNo 主键
     * @return 实例对象
     */
    TConGift queryById(Integer conGNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConGift> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tConGift 实例对象
     * @return 实例对象
     */
    TConGift insert(TConGift tConGift);

    /**
     * 修改数据
     *
     * @param tConGift 实例对象
     * @return 实例对象
     */
    TConGift update(TConGift tConGift);

    /**
     * 通过主键删除数据
     *
     * @param conGNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer conGNo);

}