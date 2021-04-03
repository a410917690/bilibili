package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TFan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 番剧(TFan)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:23:47
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TFanDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_fan where fan_no=#{fan_no}")
    TFan queryById(Integer fan_no);

    @Select("select * from t_fan")
    List<TFan> queryAllByPage();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFan 实例对象
     * @return 对象列表
     */
    List<TFan> queryAll(TFan tFan);

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    int insert(TFan tFan);

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    @Update("update t_fan set fan_title=#{fan_title},m_no=#{m_no},fan_pic=#{fan_pic} where fan_no=#{fan_no}")
    int update(TFan tFan);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
    @Delete("delete from t_fan where fan_no=#{fan_no}")
    int deleteById(Integer fan_no);

}