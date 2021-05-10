package org.lanqiao.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TLLRooms;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TLLRoomsDao {

    /**
     * 判断当前用户是否已经给当前直播间点过赞
     */
    @Select("select * from t_like_live_rooms where con_no=#{con_no} and room_no=#{room_no}")
    TLLRooms getLLRoom(@Param("con_no") Integer con_no,@Param("room_no") Integer room_no);


    /**
     * 给直播间点赞
     */
    @Insert("insert into t_like_live_rooms (room_no,con_no) values (#{room_no},#{con_no})")
    boolean insertTLLroom(@Param("room_no") Integer room_no,@Param("con_no") Integer con_no);
}
