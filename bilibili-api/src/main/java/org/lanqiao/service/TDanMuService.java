package org.lanqiao.service;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TDanMu;

import java.util.List;

/**
 * 弹幕(TDanMu)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:28
 */
public interface TDanMuService {

    /**
     * 通过ID查询单条数据
     *
     * @param danNo 主键
     * @return 实例对象
     */
    TDanMu queryById(Integer danNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TDanMu> queryAllByLimit(int offset, int limit);

    List<TDanMu> queryAll(Integer v_no);

    /**
     * 新增数据
     *
     * @param tDanMu 实例对象
     * @return 实例对象
     */
    boolean insert(TDanMu tDanMu);

    /**
     * 修改数据
     *
     * @param tDanMu 实例对象
     * @return 实例对象
     */
    TDanMu update(TDanMu tDanMu);

    /**
     * 通过主键删除数据
     *
     * @param danNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer danNo);

}