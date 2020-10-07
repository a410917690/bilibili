package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.TRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色(TRoles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:29
 */
@Repository
@Mapper
public interface TRolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleNo 主键
     * @return 实例对象
     */
    TRoles queryById(Integer roleNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tRoles 实例对象
     * @return 对象列表
     */
    List<TRoles> queryAll(TRoles tRoles);

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 影响行数
     */
    int insert(TRoles tRoles);

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 影响行数
     */
    int update(TRoles tRoles);

    /**
     * 通过主键删除数据
     *
     * @param roleNo 主键
     * @return 影响行数
     */
    int deleteById(Integer roleNo);

}