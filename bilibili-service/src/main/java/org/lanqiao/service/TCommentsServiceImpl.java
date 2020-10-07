package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TCommentsDao;
import org.lanqiao.entity.TComments;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论(TComments)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TCommentsServiceImpl implements TCommentsService {
    @Resource
    private TCommentsDao tCommentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param comNo 主键
     * @return 实例对象
     */
    @Override
    public TComments queryById(Integer comNo) {
        return this.tCommentsDao.queryById(comNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TComments> queryAllByLimit(int offset, int limit) {
        return this.tCommentsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    @Override
    public TComments insert(TComments tComments) {
        this.tCommentsDao.insert(tComments);
        return tComments;
    }

    /**
     * 修改数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    @Override
    public TComments update(TComments tComments) {
        this.tCommentsDao.update(tComments);
        return this.queryById(tComments.getCom_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param comNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer comNo) {
        return this.tCommentsDao.deleteById(comNo) > 0;
    }
}