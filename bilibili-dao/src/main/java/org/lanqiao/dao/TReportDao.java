package org.lanqiao.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TReport;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TReportDao {

    /**
     * 通过用户con_no查询此用户举报的各种信息
     */
    @Select("select * from t_report where con_no=#{con_no}")
    List<TReport> getTreportByConNo(Integer con_no);

    /**
     * 查询某用户是否举报过某视频
     */
    @Select("select * from t_report where con_no=#{con_no} and v_no=#{v_no}")
    TReport getTreportByConNoV(@Param("con_no") Integer con_no,@Param("v_no")Integer v_no);



    /**
     * 查询某用户是否举报过某直播间
     */
    @Select("select * from t_report where con_no=#{con_no} and room_no=#{room_no}")
    TReport getTreportByConNoR(@Param("con_no") Integer con_no,@Param("room_no")Integer room_no);


    /**
     * 举报视频插入t_report表中（当该用户还未举报过时）
     */
    @Insert("insert into t_report(con_no,v_no,reason) values(#{con_no},#{v_no},#{reason})")
    int insertVideosReport(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no,@Param("reason") String reason);


}
