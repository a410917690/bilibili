package org.lanqiao.service;

import org.lanqiao.entity.THistory;

import java.util.List;

/**
 * 观看历史(THistory)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:29
 */
public interface THistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param hisNo 主键
     * @return 实例对象
     */
    THistory queryById(Integer hisNo);

    /**
     * 查询多条数据
     *

     * @return 对象列表
     */
    List<THistory> queryAllHisByCon(Integer con_no);

    /**
     * 新增数据
     *

     * @return 实例对象
     */
    boolean insert(Integer con_no,Integer v_no);

    /**
     * 修改数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    THistory update(THistory tHistory);

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    boolean deleteById(Integer con_no,Integer v_no);

}