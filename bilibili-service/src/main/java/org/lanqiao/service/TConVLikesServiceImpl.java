package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TConVLikesDao;
import org.lanqiao.entity.TConVLikes;
import org.lanqiao.service.TConVLikesService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户点赞过 的视频(TConVLikes)表服务实现类
 *
 * @author makejava
 * @since 2020-10-11 15:37:05
 */
@Service
@Component
public class TConVLikesServiceImpl implements TConVLikesService {
    @Resource
    private TConVLikesDao tConVLikesDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */


    @Override
    public boolean queryByVnoCno(Integer con_no,Integer v_no) {
        if(this.tConVLikesDao.queryByVnoCno(con_no,v_no) == null ){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TConVLikes> queryAllByLimit(int offset, int limit) {
        return this.tConVLikesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *

     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no,Integer v_no) {
        this.tConVLikesDao.insert(con_no,v_no);
        return true;
    }

    /**
     * 修改数据
     *
     * @param tConVLikes 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param conVLikesNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer conVLikesNo) {
        return this.tConVLikesDao.deleteById(conVLikesNo) > 0;
    }
}