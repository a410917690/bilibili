package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.THistoryDao;
import org.lanqiao.entity.THistory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 观看历史(THistory)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class THistoryServiceImpl implements THistoryService {
    @Resource
    private THistoryDao tHistoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hisNo 主键
     * @return 实例对象
     */
    @Override
    public THistory queryById(Integer hisNo) {
        return this.tHistoryDao.queryById(hisNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<THistory> queryAllByLimit(int offset, int limit) {
        return this.tHistoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    @Override
    public THistory insert(THistory tHistory) {
        this.tHistoryDao.insert(tHistory);
        return tHistory;
    }

    /**
     * 修改数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    @Override
    public THistory update(THistory tHistory) {
        this.tHistoryDao.update(tHistory);
        return this.queryById(tHistory.getHis_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param hisNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer hisNo) {
        return this.tHistoryDao.deleteById(hisNo) > 0;
    }
}