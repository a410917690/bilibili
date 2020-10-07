package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.TComComment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论的评论(TComComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:22:12
 */
@Repository
@Mapper
public interface TComCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param comComNo 主键
     * @return 实例对象
     */
    TComComment queryById(Integer comComNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TComComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tComComment 实例对象
     * @return 对象列表
     */
    List<TComComment> queryAll(TComComment tComComment);

    /**
     * 新增数据
     *
     * @param tComComment 实例对象
     * @return 影响行数
     */
    int insert(TComComment tComComment);

    /**
     * 修改数据
     *
     * @param tComComment 实例对象
     * @return 影响行数
     */
    int update(TComComment tComComment);

    /**
     * 通过主键删除数据
     *
     * @param comComNo 主键
     * @return 影响行数
     */
    int deleteById(Integer comComNo);

}