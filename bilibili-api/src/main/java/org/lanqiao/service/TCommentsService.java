package org.lanqiao.service;

import org.lanqiao.entity.TComments;

import java.util.List;

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
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TComments> queryAllByLimit(int offset, int limit);

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

    /**
     * 通过主键删除数据
     *
     * @param comNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer comNo);

}