package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TRoomCon;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 来到直播间的用户(TRoomCon)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:22:23
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TRoomConDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roomConNo 主键
     * @return 实例对象
     */
    TRoomCon queryById(Integer roomConNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TRoomCon> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tRoomCon 实例对象
     * @return 对象列表
     */
    List<TRoomCon> queryAll(TRoomCon tRoomCon);

    /**
     * 新增数据
     *
     * @param tRoomCon 实例对象
     * @return 影响行数
     */
    int insert(TRoomCon tRoomCon);

    /**
     * 修改数据
     *
     * @param tRoomCon 实例对象
     * @return 影响行数
     */
    int update(TRoomCon tRoomCon);

    /**
     * 通过主键删除数据
     *
     * @param roomConNo 主键
     * @return 影响行数
     */
    int deleteById(Integer roomConNo);

}