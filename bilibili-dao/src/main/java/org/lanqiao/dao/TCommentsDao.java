package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
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



    @Select("select * from t_comments where v_no in (select v_no from t_videos where v_no = #{v_no})")
    List<TComments> queryAllByVno(Integer v_no);

    /**
     * 通过实体作为筛选条件查询
     *
     *


    /**
     * 新增数据
     *
     * @param tComments 实例对象
     * @return 影响行数
     */
    @Insert("insert into t_comments (v_no,con_no,con_comment) values (#{v_no},#{con_no},#{con_comment})")
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

     * @return 影响行数
     */
    @Delete("delete from t_comments where v_no=#{v_no} and con_no=#{con_no}")
    int deleteByVno(@Param("v_no") Integer v_no,@Param("con_no") Integer con_no);

}