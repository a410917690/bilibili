package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TVTagDao;
import org.lanqiao.entity.TVTag;
import org.lanqiao.service.TVTagService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 视频标签(TVTag)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:07
 */
@Service
@Component
public class TVTagServiceImpl implements TVTagService {
    @Resource
    private TVTagDao tVTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vTagNo 主键
     * @return 实例对象
     */
    @Override
    public TVTag queryById(Integer vTagNo) {
        return this.tVTagDao.queryById(vTagNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TVTag> queryAllByLimit(int offset, int limit) {
        return this.tVTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tVTag 实例对象
     * @return 实例对象
     */
    @Override
    public TVTag insert(TVTag tVTag) {
        this.tVTagDao.insert(tVTag);
        return tVTag;
    }

    /**
     * 修改数据
     *
     * @param tVTag 实例对象
     * @return 实例对象
     */
    @Override
    public TVTag update(TVTag tVTag) {
        this.tVTagDao.update(tVTag);
        return this.queryById(tVTag.getV_tag_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param vTagNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer vTagNo) {
        return this.tVTagDao.deleteById(vTagNo) > 0;
    }
}