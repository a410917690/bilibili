package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.TComments;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论(TComments)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:23:24
 */
@Repository
@Mapper
public interface TCommentsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param comNo 主键
     * @return 实例对象
     */
    TComments queryById(Integer comNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TComments> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tComments 实例对象
     * @return 对象列表
     */
    List<TComments> queryAll(TComments tComments);

    /**
     * 新增数据
     *
     * @param tComments 实例对象
     * @return 影响行数
     */
    int insert(TComments tComments);

    /**
     * 修改数据
     *
     * @param tComments 实例对象
     * @return 影响行数
     */
    int update(TComments tComments);

    /**
     * 通过主键删除数据
     *
     * @param comNo 主键
     * @return 影响行数
     */
    int deleteById(Integer comNo);

}