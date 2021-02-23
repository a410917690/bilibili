package org.lanqiao.service;

import org.lanqiao.entity.TComments;

/**
 * 评论(TComments)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:28
 */
public interface TCommentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param comNo 主键
     * @return 实例对象
     */
    TComments queryById(Integer comNo);

    /**
     * 查询多条数据
     *n 对象列表
     */



    Object queryAllByVno(int pageNum,int pageSize,Integer v_no);

    /**
     * 新增数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    TComments insert(TComments tComments);

    /**
     * 修改数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    TComments update(TComments tComments);

    String deleteComment(Integer v_no,Integer con_no);

    /**
     * 通过主键删除数据
     *
     * @param comNo 主键
     * @return 是否成功
     */


}