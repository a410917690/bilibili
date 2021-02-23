package org.lanqiao.service;

import org.lanqiao.entity.TComComment;
import org.lanqiao.vo.TCommentVo;

import java.util.List;

/**
 * 评论的评论(TComComment)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:27
 */
public interface TComCommentService {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */

    Integer queryComNo(Integer v_no,Integer con_no);


    List<TCommentVo> getComReply(Integer v_no,Integer con_no);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TComComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *

     * @return 实例对象
     */
    boolean insert(String com_com,Integer con_no,Integer com_no);

    /**
     * 修改数据
     *
     * @param tComComment 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param comComNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer comComNo);

}