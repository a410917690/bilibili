package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TLLRoomsDao;
import org.lanqiao.dao.TLiveRoomsDao;
import org.lanqiao.dao.TReportDao;
import org.lanqiao.entity.TLiveRooms;
import org.lanqiao.service.TLiveRoomsService;
import org.lanqiao.service.TReportService;
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

    @Resource
    private TReportService tReportService;

    @Resource
    private TReportDao tReportDao;

    @Resource
    private TLLRoomsDao tllRoomsDao;
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

    @Override
    public List<TLiveRooms> getAllLives() {
        return this.tLiveRoomsDao.getAllLives();
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
    public boolean insert(TLiveRooms tLiveRooms) {
        return this.tLiveRoomsDao.playLive(tLiveRooms)>0;
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

    @Override
    public boolean closeLive(Integer room_no) {
        return this.tLiveRoomsDao.closeLive(room_no) > 0;
    }

    @Override
    public boolean updateReportRoom(Integer con_no, Integer room_no, String reason) {
        if (tReportService.getTreportByConNoR(con_no,room_no) == false) {
            if (this.tLiveRoomsDao.updateRoomReports(room_no) > 0 && this.tReportDao.insertRoomsReport(con_no, room_no,reason) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean likeRoom(Integer con_no, Integer room_no) {
        if (tllRoomsDao.getLLRoom(con_no,room_no)!=null){
            return false;
        }else {
            if (tllRoomsDao.insertTLLroom(room_no,con_no)  && tLiveRoomsDao.likeRoom (room_no) > 0){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public boolean isLikeRoom(Integer con_no, Integer room_no) {
        return this.tllRoomsDao.getLLRoom(con_no,room_no) != null;
    }
}