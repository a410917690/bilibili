package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
@CacheNamespace(implementation = RedisCache.class)
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

    @Select("select * from t_live_rooms")
    List<TLiveRooms> queryAllByPage();

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