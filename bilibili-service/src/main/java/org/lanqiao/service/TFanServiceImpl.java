package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TFanDao;
import org.lanqiao.entity.TFan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 番剧(TFan)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TFanServiceImpl implements TFanService {
    @Resource
    private TFanDao tFanDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Override
    public TFan queryById(String fan_title) {
        return this.tFanDao.queryById(fan_title);
    }

    @Override
    public PageInfo<TFan> queryAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TFan> list = tFanDao.queryAllByPage();
        return new PageInfo<>(list);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TFan> queryAllByLimit(int offset, int limit) {
        return this.tFanDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    @Override
    public TFan insert(TFan tFan) {
        this.tFanDao.insert(tFan);
        return tFan;
    }

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    @Override
    public TFan update(TFan tFan) {
        this.tFanDao.update(tFan);
        return this.queryById(tFan.getFan_title());
    }

    /**
     * 通过主键删除数据
     *
     * @param fanNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fanNo) {
        return this.tFanDao.deleteById(fanNo) > 0;
    }
}