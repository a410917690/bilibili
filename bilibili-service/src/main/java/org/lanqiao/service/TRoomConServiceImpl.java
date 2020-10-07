package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TRoomConDao;
import org.lanqiao.entity.TRoomCon;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 来到直播间的用户(TRoomCon)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TRoomConServiceImpl implements TRoomConService {
    @Resource
    private TRoomConDao tRoomConDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roomConNo 主键
     * @return 实例对象
     */
    @Override
    public TRoomCon queryById(Integer roomConNo) {
        return this.tRoomConDao.queryById(roomConNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TRoomCon> queryAllByLimit(int offset, int limit) {
        return this.tRoomConDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tRoomCon 实例对象
     * @return 实例对象
     */
    @Override
    public TRoomCon insert(TRoomCon tRoomCon) {
        this.tRoomConDao.insert(tRoomCon);
        return tRoomCon;
    }

    /**
     * 修改数据
     *
     * @param tRoomCon 实例对象
     * @return 实例对象
     */
    @Override
    public TRoomCon update(TRoomCon tRoomCon) {
        this.tRoomConDao.update(tRoomCon);
        return this.queryById(tRoomCon.getRoom_con_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param roomConNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roomConNo) {
        return this.tRoomConDao.deleteById(roomConNo) > 0;
    }
}