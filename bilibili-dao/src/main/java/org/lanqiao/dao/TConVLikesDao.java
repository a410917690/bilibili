package org.lanqiao.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TConVLikes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户点赞过 的视频(TConVLikes)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 15:37:34
 */
@Repository
@Mapper
public interface TConVLikesDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_con_v_likes where con_no=#{con_no} and v_no=#{v_no}")
    TConVLikes queryByVnoCno(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConVLikes> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConVLikes 实例对象
     * @return 对象列表
     */
    List<TConVLikes> queryAll(TConVLikes tConVLikes);

    /**
     * 新增数据
     *

     * @return 影响行数
     */
    @Insert("insert into t_con_v_likes (con_no,v_no) values (#{con_no},#{v_no})")
    int insert(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no);

    /**
     * 修改数据
     *
     * @param tConVLikes 实例对象
     * @return 影响行数
     */
    int update(TConVLikes tConVLikes);

    /**
     * 通过主键删除数据
     *
     * @param conVLikesNo 主键
     * @return 影响行数
     */
    int deleteById(Integer conVLikesNo);

}