package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TManagers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员(TManagers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:23
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TManagersDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_managers where name=#{name}")
    TManagers queryById(String name);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TManagers> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tManagers 实例对象
     * @return 对象列表
     */
    List<TManagers> queryAll(TManagers tManagers);

    /**
     * 新增数据
     *
     * @param tManagers 实例对象
     * @return 影响行数
     */
    int insert(TManagers tManagers);

    /**
     * 修改数据
     *
     * @param tManagers 实例对象
     * @return 影响行数
     */
    int update(TManagers tManagers);

    /**
     * 通过主键删除数据
     *
     * @param mNo 主键
     * @return 影响行数
     */
    int deleteById(Integer mNo);

}