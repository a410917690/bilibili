package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.THistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 观看历史(THistory)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:24:53
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface THistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Select("select * from t_history where con_no=#{con_no} and v_no=#{v_no}")
    THistory queryByCnoVno(@Param("con_no")Integer con_no,@Param("v_no")Integer v_no);


    /**
     * 查询指定行数据
     *
     */
    @Select("select * from t_history where con_no=#{con_no} order by his_no desc")
    List<THistory> queryAllHisBycon(Integer con_no);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tHistory 实例对象
     * @return 对象列表
     */
    List<THistory> queryAll(THistory tHistory);

    /**
     * 新增数据
     *

     * @return 影响行数
     */
    @Insert("insert into t_history (con_no,v_no) values (#{con_no},#{v_no})")
    int insert(@Param("con_no")Integer con_no,@Param("v_no")Integer v_no);

    /**
     * 修改数据
     *
     * @param tHistory 实例对象
     * @return 影响行数
     */

    int update(THistory tHistory);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
    @Delete("delete from t_history where con_no=#{con_no} and v_no=#{v_no}")
    int deleteById(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no);

}