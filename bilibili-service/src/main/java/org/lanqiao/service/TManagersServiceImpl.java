package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TManagersDao;
import org.lanqiao.entity.TManagers;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员(TManagers)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TManagersServiceImpl implements TManagersService {
    @Resource
    private TManagersDao tManagersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mNo 主键
     * @return 实例对象
     */
    @Override
    public TManagers queryById(Integer mNo) {
        return this.tManagersDao.queryById(mNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TManagers> queryAllByLimit(int offset, int limit) {
        return this.tManagersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tManagers 实例对象
     * @return 实例对象
     */
    @Override
    public TManagers insert(TManagers tManagers) {
        this.tManagersDao.insert(tManagers);
        return tManagers;
    }

    /**
     * 修改数据
     *
     * @param tManagers 实例对象
     * @return 实例对象
     */
    @Override
    public TManagers update(TManagers tManagers) {
        this.tManagersDao.update(tManagers);
        return this.queryById(tManagers.getM_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param mNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mNo) {
        return this.tManagersDao.deleteById(mNo) > 0;
    }
}