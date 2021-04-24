package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TVideos;
import org.lanqiao.vo.VideoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频(TVideos)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:27:01
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TVideosDao {


    /**
     * 通过v_no查询单个视频
     *
     */
    @Select("select c.name,t.* from t_consumers c,(select v.con_no,v.v_amount_of_play,v.v_coins,v.v_legal,v.v_likes,v.v_no,v.v_pic,v.v_reports,v.v_title,v.v_url from t_videos v where v_no=#{v_no})t where c.con_no = t.con_no")
    VideoVo queryById(Integer v_no);


    /**
     * 获取单个标签下的所有视频
     * @param t_no
     * @return
     */
    @Select("select * from t_videos where v_no =(select v_no from t_v_tag where t_no=#{t_no})")
    List<TVideos> queryByTag(Integer t_no);
    //以上方法有错误，有bug


    /**
     * 获取所有视频
     * @return
     */
    @Select("select * from t_videos order by v_no desc")
    List<TVideos> getListByPage();


    /**
     * 新增视频
     * （投稿视频）
     *
     */
    @Insert("insert into t_videos (v_title,v_amount_of_play,v_url,con_no,v_likes,v_pic,v_coins,v_reports,v_legal) values (#{v_title},0,#{v_url},#{con_no},0,#{v_pic},0,0,1)")
    int insert(TVideos tVideos);

    /**
     * 修改视频信息
     *
     * @param tVideos 实例对象
     * @return 影响行数
     */
    @Update("update t_videos set v_title= #{v_title},v_url=#{v_url},v_pic =#{v_pic} where v_no=#{v_no}")
    int update(TVideos tVideos);


    /**
     * 修改视频的点赞数
     * @param
     * @param v_no
     * @return
     */
    @Update("update t_videos set v_likes=#{likes} where v_no=#{v_no}")
    int updateLikeNum(Integer v_no,Integer likes);


    /**
     * 修改视频的投币数
     * @param v_no
     * @return
     */
    @Update("update t_videos set v_coins=v_coins+1 where v_no=#{v_no}")
    int updateVideosCoins(Integer v_no);


    /**
     * 通过v_no删除视频
     * @return 影响行数
     */
    @Delete("delete from t_videos where v_no=#{v_no}")
    int deleteById(Integer v_no);

    /**
     * 举报视频插入v_videos表中
     */
    @Update("update t_videos set v_reports = v_reports+1 where v_no = #{v_no}   ")
    int updateVideosReports(Integer v_no);


    @Select("select v_likes from t_videos where v_no=#{v_no}")
    int getLike(Integer v_no);


}