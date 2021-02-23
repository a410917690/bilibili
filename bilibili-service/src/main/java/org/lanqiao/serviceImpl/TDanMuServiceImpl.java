package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TDanMuDao;
import org.lanqiao.entity.TDanMu;
import org.lanqiao.service.TDanMuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 弹幕(TDanMu)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TDanMuServiceImpl implements TDanMuService {
    @Resource
    private TDanMuDao tDanMuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param danNo 主键
     * @return 实例对象
     */
    @Override
    public TDanMu queryById(Integer danNo) {
        return this.tDanMuDao.queryById(danNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TDanMu> queryAllByLimit(int offset, int limit) {
        return this.tDanMuDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TDanMu> queryAll(Integer v_no) {
        return this.tDanMuDao.queryAll(v_no);
    }

    /**
     * 新增数据
     *
     * @param tDanMu 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(TDanMu tDanMu) {
        this.tDanMuDao.insert(tDanMu);
        return true;
    }

    /**
     * 修改数据
     *
     * @param tDanMu 实例对象
     * @return 实例对象
     */
    @Override
    public TDanMu update(TDanMu tDanMu) {
        this.tDanMuDao.update(tDanMu);
        return this.queryById(tDanMu.getDan_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param danNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer danNo) {
        return this.tDanMuDao.deleteById(danNo) > 0;
    }
}