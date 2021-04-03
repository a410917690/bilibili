package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TTag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标签(TTag)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:49
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tNo 主键
     * @return 实例对象
     */
    TTag queryById(Integer tNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TTag> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *

     * @return 对象列表
     */
    @Select("select * from t_tag")
    List<TTag> queryAll();

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int insert(TTag tTag);

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int update(TTag tTag);

    /**
     * 通过主键删除数据
     *
     * @param tNo 主键
     * @return 影响行数
     */
    int deleteById(Integer tNo);

}