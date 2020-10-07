package org.lanqiao.service;

import org.lanqiao.entity.TManagers;

import java.util.List;

/**
 * 管理员(TManagers)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TManagersService {

    /**
     * 通过ID查询单条数据
     *
     * @param mNo 主键
     * @return 实例对象
     */
    TManagers queryById(Integer mNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TManagers> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tManagers 实例对象
     * @return 实例对象
     */
    TManagers insert(TManagers tManagers);

    /**
     * 修改数据
     *
     * @param tManagers 实例对象
     * @return 实例对象
     */
    TManagers update(TManagers tManagers);

    /**
     * 通过主键删除数据
     *
     * @param mNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mNo);

}