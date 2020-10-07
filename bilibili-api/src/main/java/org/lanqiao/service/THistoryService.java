package org.lanqiao.service;

import org.lanqiao.entity.THistory;

import java.util.List;

/**
 * 观看历史(THistory)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface THistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param hisNo 主键
     * @return 实例对象
     */
    THistory queryById(Integer hisNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<THistory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    THistory insert(THistory tHistory);

    /**
     * 修改数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    THistory update(THistory tHistory);

    /**
     * 通过主键删除数据
     *
     * @param hisNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer hisNo);

}