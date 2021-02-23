package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TGiftDao;
import org.lanqiao.entity.TGift;
import org.lanqiao.service.TGiftService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 礼物(TGift)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TGiftServiceImpl implements TGiftService {
    @Resource
    private TGiftDao tGiftDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gNo 主键
     * @return 实例对象
     */
    @Override
    public TGift queryById(Integer gNo) {
        return this.tGiftDao.queryById(gNo);
    }

    @Override
    public List<TGift> queryAll() {
        return this.tGiftDao.queryAll();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TGift> queryAllByLimit(int offset, int limit) {
        return this.tGiftDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tGift 实例对象
     * @return 实例对象
     */
    @Override
    public TGift insert(TGift tGift) {
        this.tGiftDao.insert(tGift);
        return tGift;
    }

    /**
     * 修改数据
     *
     * @param tGift 实例对象
     * @return 实例对象
     */
    @Override
    public TGift update(TGift tGift) {
        this.tGiftDao.update(tGift);
        return this.queryById(tGift.getG_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param gNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gNo) {
        return this.tGiftDao.deleteById(gNo) > 0;
    }
}