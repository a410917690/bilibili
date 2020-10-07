package org.lanqiao.service;

import org.lanqiao.entity.TGift;

import java.util.List;

/**
 * 礼物(TGift)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TGiftService {

    /**
     * 通过ID查询单条数据
     *
     * @param gNo 主键
     * @return 实例对象
     */
    TGift queryById(Integer gNo);

    List<TGift> queryAll();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TGift> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tGift 实例对象
     * @return 实例对象
     */
    TGift insert(TGift tGift);

    /**
     * 修改数据
     *
     * @param tGift 实例对象
     * @return 实例对象
     */
    TGift update(TGift tGift);

    /**
     * 通过主键删除数据
     *
     * @param gNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gNo);

}