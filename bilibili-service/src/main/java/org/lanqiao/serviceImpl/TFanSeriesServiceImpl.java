package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TFanSeriesDao;
import org.lanqiao.entity.TFanSeries;
import org.lanqiao.service.TFanSeriesService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 剧集(TFanSeries)表服务实现类
 *
 * @author makejava
 * @since 2020-10-09 19:07:32
 */
@Service
@Component
public class TFanSeriesServiceImpl implements TFanSeriesService {
    @Resource
    private TFanSeriesDao tFanSeriesDao;

    @Override
    public TFanSeries queryById(Integer fan_series_no) {
        return this.tFanSeriesDao.queryById(fan_series_no);
    }

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Override
    public PageInfo<TFanSeries> querySeries(int pageNum,int pageSize,Integer fan_no) {
        PageHelper.startPage(pageNum,pageSize);
        List<TFanSeries> list = tFanSeriesDao.querySeries(fan_no);
        return new PageInfo<>(list);
    }

    @Override
    public List<TFanSeries> getFanSeries(Integer fan_no) {
        return this.tFanSeriesDao.querySeries(fan_no);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TFanSeries> queryAllByLimit(int offset, int limit) {
        return this.tFanSeriesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    @Override
    public TFanSeries insert(TFanSeries tFanSeries) {
        this.tFanSeriesDao.insert(tFanSeries);
        return tFanSeries;
    }

    /**
     * 修改数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    @Override
    public TFanSeries update(TFanSeries tFanSeries) {
        this.tFanSeriesDao.update(tFanSeries);
        return this.queryById(tFanSeries.getFan_series_no());
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer fan_series_no) {
        this.tFanSeriesDao.deleteById(fan_series_no);
        return "删除成功!";
    }
}