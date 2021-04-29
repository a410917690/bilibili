package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TTagDao;
import org.lanqiao.entity.TTag;
import org.lanqiao.service.TTagService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签(TTag)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TTagServiceImpl implements TTagService {
    @Resource
    private TTagDao tTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tNo 主键
     * @return 实例对象
     */
    @Override
    public TTag queryById(Integer tNo) {
        return this.tTagDao.queryById(tNo);
    }

    @Override
    public String getTagName(Integer t_no) {
        return this.tTagDao.getTagName(t_no);
    }

    @Override
    public List<TTag> queryAll() {
        return this.tTagDao.queryAll();
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TTag> queryAllByLimit(int offset, int limit) {
        return this.tTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag insert(TTag tTag) {
        this.tTagDao.insert(tTag);
        return tTag;
    }

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag update(TTag tTag) {
        this.tTagDao.update(tTag);
        return this.queryById(tTag.getT_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param tNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tNo) {
        return this.tTagDao.deleteById(tNo) > 0;
    }
}