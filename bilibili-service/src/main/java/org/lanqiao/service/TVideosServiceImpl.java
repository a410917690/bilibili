package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TVideosDao;
import org.lanqiao.entity.TVideos;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 视频(TVideos)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:06
 */
@Service
@Component
public class TVideosServiceImpl implements TVideosService {
    @Resource
    private TVideosDao tVideosDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Override
    public TVideos queryById(Integer v_no) {
        return this.tVideosDao.queryById(v_no);
    }

    @Override
    public List<TVideos> queryAllByLimit(int offset, int limit) {
        return null;
    }



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */


    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    @Override
    public TVideos insert(TVideos tVideos) {
        this.tVideosDao.insert(tVideos);
        return tVideos;
    }

    /**
     * 修改数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    @Override
    public TVideos update(TVideos tVideos) {
        this.tVideosDao.update(tVideos);
        return tVideosDao.queryById(tVideos.getV_no());

    }

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    @Override
    public String deleteById(Integer v_no) {
        this.tVideosDao.deleteById(v_no);
        return "删除成功！";
    }

    @Override
    public PageInfo<TVideos> getAllVideosByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TVideos> list = tVideosDao.getListByPage();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<TVideos> getVideosByTag(int pageNum,int pageSize,Integer t_no){
        PageHelper.startPage(pageNum,pageSize);
        List<TVideos> list = tVideosDao.queryByTag(t_no);
        return new PageInfo<>(list);
    }
}