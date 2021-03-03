package org.lanqiao.service;

import org.lanqiao.entity.TVideos;

import java.util.List;

/**
 * 视频(TVideos)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface TVideosService {

    /**
     * 通过v_no查询单个视频
     *
     *
     */
    TVideos queryById(Integer v_no);



    /**
     * 新增视频
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    TVideos insert(TVideos tVideos);

    /**
     * 修改视频信息
     * @param tVideos 实例对象
     * @return 实例对象
     */
    TVideos update(TVideos tVideos);



    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    String deleteById(Integer v_no);

    /**
     * 获取所有视频（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
     Object getAllVideosByPage(int pageNum,int pageSize);

    /**
     * 通过标签获取所有视频（分页）
     * @param pageNum
     * @param pageSize
     * @param t_no
     * @return
     */
     Object getVideosByTag(int pageNum,int pageSize,Integer t_no);


    /**
     * 给视频点赞数
     * @param v_no
     */
    int updateLikeNum(Integer v_no);


    /**
     * 举报视频
     */
    boolean updateReportVideo(Integer con_no,Integer v_no);

    int getLike(Integer v_no);
}