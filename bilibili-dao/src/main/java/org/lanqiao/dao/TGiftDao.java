package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TGift;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 礼物(TGift)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:24:46
 */
@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TGiftDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gNo 主键
     * @return 实例对象
     */
    TGift queryById(Integer gNo);

    @Select("select * from t_gift order by g_price asc")
    List<TGift> queryAll();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TGift> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tGift 实例对象
     * @return 对象列表
     */
    List<TGift> queryAll(TGift tGift);

    /**
     * 新增数据
     *
     * @param tGift 实例对象
     * @return 影响行数
     */
    int insert(TGift tGift);

    /**
     * 修改数据
     *
     * @param tGift 实例对象
     * @return 影响行数
     */
    int update(TGift tGift);

    /**
     * 通过主键删除数据
     *
     * @param gNo 主键
     * @return 影响行数
     */
    int deleteById(Integer gNo);

}