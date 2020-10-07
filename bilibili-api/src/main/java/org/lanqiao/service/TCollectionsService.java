package org.lanqiao.service;

import org.lanqiao.entity.TCollections;

import java.util.List;

/**
 * 收藏(TCollections)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:25
 */
public interface TCollectionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param colNo 主键
     * @return 实例对象
     */
    TCollections queryById(Integer colNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TCollections> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tCollections 实例对象
     * @return 实例对象
     */
    TCollections insert(TCollections tCollections);

    /**
     * 修改数据
     *
     * @param tCollections 实例对象
     * @return 实例对象
     */
    TCollections update(TCollections tCollections);

    /**
     * 通过主键删除数据
     *
     * @param colNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer colNo);

}