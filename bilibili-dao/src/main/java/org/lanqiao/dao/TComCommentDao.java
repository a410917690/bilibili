package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TComComment;
import org.lanqiao.vo.TCommentVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论的评论(TComComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:22:12
 */
@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TComCommentDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select com_no from t_comments where v_no=#{v_no} and con_no=#{con_no}")
    int queryComNo(@Param("v_no") Integer v_no,@Param("con_no") Integer con_no);


//    @Select("select * from t_com_comment where com_no=(select com_no from t_comments where v_no=#{v_no} and con_no=#{con_no})")
    @Select("select * from t_com_comment where com_no=(select com_no from t_comments where v_no=#{v_no} and con_no=#{con_no})")
    List<TCommentVo> queryComReply(@Param("com_no") Integer v_no,@Param("con_no") Integer con_no);


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

     * @return 影响行数
     */
    @Insert("insert into t_com_comment (com_com,con_no,com_no) values (#{com_com},#{con_no},#{com_no})")
    int insert(@Param("com_com")String com_com,@Param("con_no") Integer con_no,@Param("com_no")Integer com_no);

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