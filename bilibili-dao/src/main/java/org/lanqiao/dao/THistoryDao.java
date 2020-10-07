package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.THistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 观看历史(THistory)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:24:53
 */
@Repository
@Mapper
public interface THistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hisNo 主键
     * @return 实例对象
     */
    THistory queryById(Integer hisNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<THistory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


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
     * @param tHistory 实例对象
     * @return 影响行数
     */
    int insert(THistory tHistory);

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
     * @param hisNo 主键
     * @return 影响行数
     */
    int deleteById(Integer hisNo);

}