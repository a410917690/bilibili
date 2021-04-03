package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TRoomGift;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 直播间收到的用户礼物(TRoomGift)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:26:44
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TRoomGiftDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roomGNo 主键
     * @return 实例对象
     */
    TRoomGift queryById(Integer roomGNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoomGift> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tRoomGift 实例对象
     * @return 对象列表
     */
    List<TRoomGift> queryAll(TRoomGift tRoomGift);

    /**
     * 新增数据
     *
     * @param tRoomGift 实例对象
     * @return 影响行数
     */
    int insert(TRoomGift tRoomGift);

    /**
     * 修改数据
     *
     * @param tRoomGift 实例对象
     * @return 影响行数
     */
    int update(TRoomGift tRoomGift);

    /**
     * 通过主键删除数据
     *
     * @param roomGNo 主键
     * @return 影响行数
     */
    int deleteById(Integer roomGNo);

}