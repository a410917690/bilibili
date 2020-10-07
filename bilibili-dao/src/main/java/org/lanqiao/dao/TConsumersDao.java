package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.TConsumers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户(TConsumers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:27:33
 */
@Repository
@Mapper
public interface TConsumersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    TConsumers queryById(Integer conNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConsumers> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConsumers 实例对象
     * @return 对象列表
     */
    List<TConsumers> queryAll(TConsumers tConsumers);

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    int insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    int update(TConsumers tConsumers);

    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 影响行数
     */
    int deleteById(Integer conNo);

}