package org.lanqiao.service;

import org.lanqiao.entity.TFan;

import java.util.List;

/**
 * 番剧(TFan)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:28
 */
public interface TFanService {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    TFan queryById(Integer fan_no);

    Object queryAllByPage(int pageNum,int pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFan> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    TFan insert(TFan tFan);

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    TFan update(TFan tFan);

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    String deleteById(Integer fan_no);

}