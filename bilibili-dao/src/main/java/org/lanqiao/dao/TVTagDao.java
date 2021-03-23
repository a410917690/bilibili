package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TVTag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频标签(TVTag)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:56
 */
@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TVTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param vTagNo 主键
     * @return 实例对象
     */
    TVTag queryById(Integer vTagNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TVTag> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tVTag 实例对象
     * @return 对象列表
     */
    List<TVTag> queryAll(TVTag tVTag);

    /**
     * 新增数据
     *
     * @param tVTag 实例对象
     * @return 影响行数
     */
    int insert(TVTag tVTag);

    /**
     * 修改数据
     *
     * @param tVTag 实例对象
     * @return 影响行数
     */
    int update(TVTag tVTag);

    /**
     * 通过主键删除数据
     *
     * @param vTagNo 主键
     * @return 影响行数
     */
    int deleteById(Integer vTagNo);

}