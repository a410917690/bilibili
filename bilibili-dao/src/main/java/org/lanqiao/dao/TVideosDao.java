package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
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
    @Select("select * from t_videos where v_no=#{v_no}")
    TVideos queryById(Integer v_no);

    @Select("select * from t_videos where v_no =(select v_no from t_v_tag where t_no=#{t_no})")
    List<TVideos> queryByTag(Integer t_no);

    @Select("select * from t_videos order by v_no desc")
            public List<TVideos> getListByPage();

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
    @Update("update t_videos set v_title= #{v_title},v_url=#{v_url},v_pic =#{v_pic},v_coins=#{v_coins} where v_no=#{v_no}")
    int update(TVideos tVideos);


    @Update("update t_videos set v_coins=v_coins + 1 where v_no=#{v_no}")
    int updateVideosCoins(Integer v_no);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
    @Delete("delete from t_videos where v_no=#{v_no}")
    int deleteById(Integer v_no);

}