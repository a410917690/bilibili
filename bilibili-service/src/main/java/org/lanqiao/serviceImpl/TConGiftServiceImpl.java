package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TConGiftDao;
import org.lanqiao.entity.TConGift;
import org.lanqiao.service.TConGiftService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户礼物(TConGift)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TConGiftServiceImpl implements TConGiftService {
    @Resource
    private TConGiftDao tConGiftDao;

    /**
     * 通过ID查询单条数据
     *
     * @param conGNo 主键
     * @return 实例对象
     */
    @Override
    public TConGift queryById(Integer conGNo) {
        return this.tConGiftDao.queryById(conGNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TConGift> queryAllByLimit(int offset, int limit) {
        return this.tConGiftDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tConGift 实例对象
     * @return 实例对象
     */
    @Override
    public TConGift insert(TConGift tConGift) {
        this.tConGiftDao.insert(tConGift);
        return tConGift;
    }

    /**
     * 修改数据
     *
     * @param tConGift 实例对象
     * @return 实例对象
     */
    @Override
    public TConGift update(TConGift tConGift) {
        this.tConGiftDao.update(tConGift);
        return this.queryById(tConGift.getCon_g_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param conGNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer conGNo) {
        return this.tConGiftDao.deleteById(conGNo) > 0;
    }
}