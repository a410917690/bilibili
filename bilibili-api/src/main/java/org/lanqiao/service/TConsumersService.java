package org.lanqiao.service;

import org.lanqiao.entity.TConsumers;
import org.lanqiao.vo.ConsumerCodeVo;

import java.util.List;
import java.util.function.BooleanSupplier;

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
    TConsumers queryByName(String name);

    public TConsumers queryByNameAndPwd(String name,String password);

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

    public boolean sendMimeMail(String email);

    public boolean registered(ConsumerCodeVo consumerCodeVo);

    public TConsumers loginInByEmail(String email, String code);

    public String findPwd(String name,String mail,String code);

    Integer updatePwd(String mail,String password);

    Integer updateDetail(String newName,String name,String tele_num,Integer age,String password,String newPwd,String confirmPwd);

    int uploadPic(byte[] pic,String name);

    int report(Integer con_no);

    int toIllegal(Integer con_no);


}