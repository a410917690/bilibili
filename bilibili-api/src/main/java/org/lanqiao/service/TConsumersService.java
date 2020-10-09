package org.lanqiao.service;

import org.lanqiao.entity.TConsumers;
import org.lanqiao.vo.ConsumersVo;

import java.util.List;

/**
 * 用户(ConsumersVo)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:28
 */
public interface TConsumersService {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    TConsumers queryById(String name);

    TConsumers queryByTel(String tel_num);

    TConsumers queryByCno(Integer con_no);

    String getRoleName(Integer con_no);

    List<TConsumers> queryAll(TConsumers tConsumers);

    List<TConsumers> queryByTelNum(TConsumers tConsumers);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConsumers> queryAllByLimit(int offset, int limit);

    public Object getAllConsumersByPage(int pageNum,int pageSize);

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    TConsumers insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     *

     */



    TConsumers update(TConsumers tConsumers);

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    String deleteById(Integer con_no);



}