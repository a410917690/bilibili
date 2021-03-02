package org.lanqiao.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TReport;
import org.springframework.stereotype.Repository;

import java.util.List;

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


}
