package org.lanqiao.service;

import org.lanqiao.entity.TConVLikes;
import org.lanqiao.vo.CnoVideoLikesVo;

import java.util.List;
import java.util.Set;

/**
 * 用户点赞过 的视频(TConVLikes)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 15:36:22
 */
public interface TConVLikesService {

    /**
     * 通过cno查询数据
     *
     *@return 实例对象
     */
    Set<CnoVideoLikesVo> queryByCno(Integer con_no);







    boolean queryByVnoCno(Integer v_no,Integer con_no);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConVLikes> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *

     * @return 实例对象
     */
    boolean insert(Integer con_no,Integer v_no);

    /**
     * 修改数据
     *
     * @param tConVLikes 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param conVLikesNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer conVLikesNo);

}