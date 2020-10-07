package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TRoomGiftDao;
import org.lanqiao.entity.TRoomGift;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 直播间收到的用户礼物(TRoomGift)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TRoomGiftServiceImpl implements TRoomGiftService {
    @Resource
    private TRoomGiftDao tRoomGiftDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roomGNo 主键
     * @return 实例对象
     */
    @Override
    public TRoomGift queryById(Integer roomGNo) {
        return this.tRoomGiftDao.queryById(roomGNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TRoomGift> queryAllByLimit(int offset, int limit) {
        return this.tRoomGiftDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tRoomGift 实例对象
     * @return 实例对象
     */
    @Override
    public TRoomGift insert(TRoomGift tRoomGift) {
        this.tRoomGiftDao.insert(tRoomGift);
        return tRoomGift;
    }

    /**
     * 修改数据
     *
     * @param tRoomGift 实例对象
     * @return 实例对象
     */
    @Override
    public TRoomGift update(TRoomGift tRoomGift) {
        this.tRoomGiftDao.update(tRoomGift);
        return this.queryById(tRoomGift.getRoom_g_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param roomGNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roomGNo) {
        return this.tRoomGiftDao.deleteById(roomGNo) > 0;
    }
}