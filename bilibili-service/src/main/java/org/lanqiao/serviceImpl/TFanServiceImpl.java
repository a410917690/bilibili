package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TFanDao;
import org.lanqiao.entity.TFan;
import org.lanqiao.service.TFanService;
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
    public TFan queryById(Integer fan_no) {
        return this.tFanDao.queryById(fan_no);
    }

    @Override
    public PageInfo<TFan> queryAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TFan> list = tFanDao.queryAllByPage();
        return new PageInfo<>(list);
    }

    @Override
    public List<TFan> getAllFan() {
        return this.tFanDao.getAllFan();
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
        return this.queryById(tFan.getFan_no());
    }

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    @Override
    public String deleteById(Integer fan_no) {
        this.tFanDao.deleteById(fan_no);
        return "删除成功！";
    }
}