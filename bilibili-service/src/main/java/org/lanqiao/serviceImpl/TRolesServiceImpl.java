package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TRolesDao;
import org.lanqiao.entity.TRoles;
import org.lanqiao.service.TRolesService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色(TRoles)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TRolesServiceImpl implements TRolesService {
    @Resource
    private TRolesDao tRolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleNo 主键
     * @return 实例对象
     */
    @Override
    public TRoles queryById(Integer roleNo) {
        return this.tRolesDao.queryById(roleNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TRoles> queryAllByLimit(int offset, int limit) {
        return this.tRolesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TRoles insert(TRoles tRoles) {
        this.tRolesDao.insert(tRoles);
        return tRoles;
    }

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TRoles update(TRoles tRoles) {
        this.tRolesDao.update(tRoles);
        return this.queryById(tRoles.getRole_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleNo) {
        return this.tRolesDao.deleteById(roleNo) > 0;
    }
}