package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TConsumersDao;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.vo.ConsumersVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户(ConsumersVo)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TConsumersServiceImpl implements TConsumersService {
    @Resource
    private TConsumersDao tConsumersDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Override
    public TConsumers queryById(String name) {
        return this.tConsumersDao.queryById(name);
    }

    @Override
    public String getRoleName(Integer con_no) {
        return this.tConsumersDao.getRoleName(con_no);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TConsumers> queryAllByLimit(int offset, int limit) {
        return this.tConsumersDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Object getAllConsumersByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TConsumers> list = tConsumersDao.getListByPage();
        return new PageInfo<>(list);

    }

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    @Override
    public TConsumers insert(TConsumers tConsumers) {
        this.tConsumersDao.insert(tConsumers);
        return tConsumers;
    }

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    @Override
    public TConsumers update(TConsumers tConsumers) {
        this.tConsumersDao.update(tConsumers);
        return this.queryById(tConsumers.getName());
    }

//    public ConsumersVo getConsumersVo(){
//        return this.tConsumersDao.getConsumersVo();
//    }


    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer conNo) {
        return this.tConsumersDao.deleteById(conNo) > 0;
    }
}