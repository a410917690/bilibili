package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TComCommentDao;
import org.lanqiao.entity.TComComment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论的评论(TComComment)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:04
 */
@Service
@Component
public class TComCommentServiceImpl implements TComCommentService {
    @Resource
    private TComCommentDao tComCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param comComNo 主键
     * @return 实例对象
     */
    @Override
    public TComComment queryById(Integer comComNo) {
        return this.tComCommentDao.queryById(comComNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TComComment> queryAllByLimit(int offset, int limit) {
        return this.tComCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tComComment 实例对象
     * @return 实例对象
     */
    @Override
    public TComComment insert(TComComment tComComment) {
        this.tComCommentDao.insert(tComComment);
        return tComComment;
    }

    /**
     * 修改数据
     *
     * @param tComComment 实例对象
     * @return 实例对象
     */
    @Override
    public TComComment update(TComComment tComComment) {
        this.tComCommentDao.update(tComComment);
        return this.queryById(tComComment.getCom_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param comComNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer comComNo) {
        return this.tComCommentDao.deleteById(comComNo) > 0;
    }
}