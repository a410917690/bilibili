package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TReportDao;
import org.lanqiao.dao.TVideosDao;
import org.lanqiao.entity.TVideos;
import org.lanqiao.service.TReportService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.vo.VideoVo;
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

    @Resource
    private TReportDao tReportDao;

    @Resource
    TReportService tReportService;


    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public VideoVo queryById(Integer v_no) {
        return this.tVideosDao.queryById(v_no);
    }


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
    public VideoVo update(TVideos tVideos) {
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

    /**
     * 获取所有视频
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TVideos> getAllVideosByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TVideos> list = tVideosDao.getListByPage();
        return new PageInfo<>(list);
    }

    @Override
    public List<TVideos> getAllVideosNotPage() {
        return this.tVideosDao.getListByPage();
    }

    /**
     * 通过标签获取其下的所有视频
     *
     * @param pageNum
     * @param pageSize
     * @param t_no
     * @return
     */
    @Override
    public PageInfo<TVideos> getVideosByTag(int pageNum, int pageSize, Integer t_no) {
        PageHelper.startPage(pageNum, pageSize);
        List<TVideos> list = tVideosDao.queryByTag(t_no);
        return new PageInfo<>(list);
    }

    /**
     * 给视频点赞
     *
     * @param v_no
     * @return
     */
    @Override
    public int updateLikeNum(Integer v_no,Integer likes) {
        return this.tVideosDao.updateLikeNum(v_no,likes);
    }

    /**
     * 举报视频
     *
     * @param con_no
     * @param v_no
     * @return
     */
    @Override
    public boolean updateReportVideo(Integer con_no, Integer v_no,String reason) {
        if (tReportService.getTreportByConNoV(con_no, v_no) == false) {
            if (this.tVideosDao.updateVideosReports(v_no) > 0 && this.tReportDao.insertVideosReport(con_no, v_no,reason) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int getLike(Integer v_no) {
        return tVideosDao.getLike(v_no);
    }
}