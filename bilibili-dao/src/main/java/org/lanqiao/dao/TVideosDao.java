package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.TVideos;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频(TVideos)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:27:01
 */
@Repository
@Mapper
public interface TVideosDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_videos where v_title=#{v_title}")
    TVideos queryById(String v_title);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TVideos> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *

     * @return 对象列表
     */
    @Select("select * from t_videos order by v_no desc")
    List<TVideos> queryAll();

    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 影响行数
     */
    int insert(TVideos tVideos);

    /**
     * 修改数据
     *
     * @param tVideos 实例对象
     * @return 影响行数
     */
    @Update("update t_videos set v_title,v_url,v_pic = #{v_title},#{v_url},#{v_pic} where v_no=#{v_no} ")
    int update(TVideos tVideos);

    /**
     * 通过主键删除数据
     *
     * @param vNo 主键
     * @return 影响行数
     */
    int deleteById(Integer vNo);

}