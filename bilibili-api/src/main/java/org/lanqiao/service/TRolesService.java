package org.lanqiao.service;

import org.lanqiao.entity.TRoles;

import java.util.List;

/**
 * 角色(TRoles)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TRolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleNo 主键
     * @return 实例对象
     */
    TRoles queryById(Integer roleNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoles> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    TRoles insert(TRoles tRoles);

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    TRoles update(TRoles tRoles);

    /**
     * 通过主键删除数据
     *
     * @param roleNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleNo);

}