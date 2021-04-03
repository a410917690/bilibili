package org.lanqiao.service;

import org.lanqiao.entity.TCollections;

import java.util.List;
import java.util.Set;

/**
 * 收藏(TCollections)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:25
 */
public interface TCollectionsService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Object queryByCno(Integer con_no,int pageNum,int pageSize);

    List getVno(Integer con_no);  //用来判断是否可以添加收藏（已收藏过就无法再收藏）;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TCollections> queryAllByLimit(int offset, int limit);


    /**
     * 新增数据
     *
     * @return 实例对象
     */
    boolean insert(Integer con_no,Integer v_no);

    /**
     * 修改数据
     * @param tCollections 实例对象
     * @return 实例对象
     */
//    TCollections update(TCollections tCollections);

    /**
     * 通过主键删除数据
     * @return 是否成功
     */
    boolean delete(Integer con_no,Integer v_no);

}