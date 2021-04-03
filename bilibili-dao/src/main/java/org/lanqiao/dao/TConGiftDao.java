package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TConGift;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户礼物(TConGift)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:22:05
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TConGiftDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conGNo 主键
     * @return 实例对象
     */
    TConGift queryById(Integer conGNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConGift> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConGift 实例对象
     * @return 对象列表
     */
    List<TConGift> queryAll(TConGift tConGift);

    /**
     * 新增数据
     *
     * @param tConGift 实例对象
     * @return 影响行数
     */
    int insert(TConGift tConGift);

    /**
     * 修改数据
     *
     * @param tConGift 实例对象
     * @return 影响行数
     */
    int update(TConGift tConGift);

    /**
     * 通过主键删除数据
     *
     * @param conGNo 主键
     * @return 影响行数
     */
    int deleteById(Integer conGNo);

}