package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.THistoryDao;
import org.lanqiao.entity.THistory;
import org.lanqiao.service.THistoryService;
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

    @Override
    public THistory queryById(Integer hisNo) {
        return null;
    }

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */


    @Override
    public List<THistory> queryAllHisByCon(Integer con_no) {
        return tHistoryDao.queryAllHisBycon(con_no);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */


    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no, Integer v_no) {
        if (this.tHistoryDao.insert(con_no, v_no) > 0) {
            return true;
        }else {
            return false;
        }
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
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer con_no, Integer v_no) {
        return this.tHistoryDao.deleteById(con_no, v_no) > 0;
    }
}