package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TLiveRooms;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 直播间(TLiveRooms)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:12
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TLiveRoomsDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_live_rooms where room_no=#{room_no}")
    TLiveRooms queryById(Integer room_no);

    /**
     * 获取所有直播间用于首页
     * @return
     */
    @Select("select * from t_live_rooms order by room_no desc")
    List<TLiveRooms> queryAllByPage();

    /**
     * 获取所有正在直播的直播间（不分页）
     */
    @Select("select * from t_live_rooms where is_live=1")
    List<TLiveRooms> getAllLives();

    /**
     *关闭直播间（修改is_ive）
     */
    @Update("update t_live_rooms set is_live=0 where room_no=#{room_no}")
    int closeLive(Integer room_no);


    /**
     * 直播间开播
     */
    @Insert("insert into t_live_rooms (room_title,con_no,room_pic,room_is_legal,is_live,report_live_num,room_likes,room_url,room_num) values (#{room_title},#{con_no},#{room_pic},#{room_is_legal},#{is_live},0,0,#{room_url},#{room_num})")
    int playLive(TLiveRooms tLiveRooms);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TLiveRooms> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tLiveRooms 实例对象
     * @return 对象列表
     */
    List<TLiveRooms> queryAll(TLiveRooms tLiveRooms);

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    @Select("insert into t_live_rooms (con_no) values(#{con_no})")
    int addLive(Integer con_no);

    /**
     * 修改数据
     *
     * @param tLiveRooms 实例对象
     * @return 影响行数
     */
    int update(TLiveRooms tLiveRooms);

    /**
     * 通过主键删除数据
     *
     * @param roomNo 主键
     * @return 影响行数
     */
    int deleteById(Integer roomNo);

}