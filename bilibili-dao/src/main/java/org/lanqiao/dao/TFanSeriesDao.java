package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;

import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TFanSeries;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 剧集(TFanSeries)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-09 19:08:03
 */
@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TFanSeriesDao {

    /**
     * 通过ID查询单条数据
     *
     *
     * @return 实例对象
     */
    @Select("select * from t_fan_series where fan_series_no=#{fan_series_no}")
    TFanSeries queryById(Integer fan_series_no);


    @Select("select * from t_fan_series where fan_no=#{fan_no}")
    List<TFanSeries> querySeries(Integer fan_no);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFanSeries> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFanSeries 实例对象
     * @return 对象列表
     */
    List<TFanSeries> queryAll(TFanSeries tFanSeries);

    /**
     * 新增数据
     *
     * @param tFanSeries 实例对象
     * @return 影响行数
     */
    int insert(TFanSeries tFanSeries);

    /**
     * 修改数据
     *
     * @param tFanSeries 实例对象
     * @return 影响行数
     */
    @Update("update t_fan_series set series_num=#{series_num},series_pic=#{series_pic},series_title=#{series_title},series_url=#{series_url} where fan_series_no=#{fan_series_no} ")
    int update(TFanSeries tFanSeries);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
    @Delete("delete from t_fan_series where fan_series_no=#{fan_series_no}")
    int deleteById(Integer fan_series_no);

}