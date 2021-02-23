package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TLiveRoomsDao;
import org.lanqiao.entity.TLiveRooms;
import org.lanqiao.service.TLiveRoomsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 直播间(TLiveRooms)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TLiveRoomsServiceImpl implements TLiveRoomsService {
    @Resource
    private TLiveRoomsDao tLiveRoomsDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */

    @Override
    public TLiveRooms queryById(Integer room_no) {
        return this.tLiveRoomsDao.queryById(room_no);
    }

    @Override
    public PageInfo<TLiveRooms> queryAllByPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TLiveRooms> list = tLiveRoomsDao.queryAllByPage();
        return new PageInfo<>(list);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TLiveRooms> queryAllByLimit(int offset, int limit) {
        return this.tLiveRoomsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tLiveRooms 实例对象
     * @return 实例对象
     */
    @Override
    public TLiveRooms insert(TLiveRooms tLiveRooms) {
        this.tLiveRoomsDao.insert(tLiveRooms);
        return tLiveRooms;
    }

    /**
     * 修改数据
     *
     * @param tLiveRooms 实例对象
     * @return 实例对象
     */
    @Override
    public TLiveRooms update(TLiveRooms tLiveRooms) {
        this.tLiveRoomsDao.update(tLiveRooms);
        return this.queryById(tLiveRooms.getRoom_no());
    }

    /**
     * 通过主键删除数据
     *
     * @param roomNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roomNo) {
        return this.tLiveRoomsDao.deleteById(roomNo) > 0;
    }
}