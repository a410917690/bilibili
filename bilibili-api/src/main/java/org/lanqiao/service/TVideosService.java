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
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */

    TVideos queryById(Integer v_no);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TVideos> queryAllByLimit(int offset, int limit);



    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    TVideos insert(TVideos tVideos);

    /**
     * 修改数据
     *
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

    public Object getAllVideosByPage(int pageNum,int pageSize);

    public Object getVideosByTag(int pageNum,int pageSize,Integer t_no);

    TVideos LikesVideos(TVideos tVideos);

    void updateLikeNum(Integer v_likes,Integer v_no);
}