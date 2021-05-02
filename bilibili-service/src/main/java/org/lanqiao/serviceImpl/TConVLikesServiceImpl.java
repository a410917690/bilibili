package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TConVLikesDao;
import org.lanqiao.entity.TConVLikes;
import org.lanqiao.service.TConVLikesService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.vo.CnoVideoLikesVo;
import org.lanqiao.vo.VideoTagVo;
import org.lanqiao.vo.VideoVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private TVideosService tVideosService;

    @Override
    public Set<CnoVideoLikesVo> queryByCno(Integer con_no) {
        List<TConVLikes> tConVLikes = this.tConVLikesDao.queryByCno(con_no);
        List<Integer> v_nos = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<CnoVideoLikesVo> cnoVideoLikesVos = new HashSet<>();
        for (TConVLikes tConVLikes1 : tConVLikes) {
            v_nos.add(tConVLikes1.getV_no());
            map.put(tConVLikes1.getV_no(), tConVLikes1.getCon_v_likes_no());
        }

        for (Integer vNo : v_nos) {
            VideoVo videoVo = tVideosService.queryById(vNo);
            CnoVideoLikesVo cnoVideoLikesVo = new CnoVideoLikesVo();

            List<VideoTagVo> tagList = tVideosService.getVideoTags(vNo);
            List<String> tagNames = new ArrayList<>();
            for (VideoTagVo tagList1:tagList) {
                tagNames.add(tagList1.getT_name());
            }
            cnoVideoLikesVo.setTagNames(tagNames);
            cnoVideoLikesVo.setBlong_con_no(videoVo.getCon_no());
            cnoVideoLikesVo.setCon_no(con_no);
            cnoVideoLikesVo.setCon_v_likes_no(map.get(vNo));
            cnoVideoLikesVo.setV_amount_of_play(videoVo.getV_amount_of_play());
            cnoVideoLikesVo.setV_coins(videoVo.getV_coins());
            cnoVideoLikesVo.setV_legal(videoVo.isV_legal());
            cnoVideoLikesVo.setV_likes(videoVo.getV_likes());
            cnoVideoLikesVo.setV_no(videoVo.getV_no());
            cnoVideoLikesVo.setV_pic(videoVo.getV_pic());
            cnoVideoLikesVo.setV_reports(videoVo.getV_reports());
            cnoVideoLikesVo.setV_title(videoVo.getV_title());
            cnoVideoLikesVo.setV_url(videoVo.getV_url());

            cnoVideoLikesVos.add(cnoVideoLikesVo);
        }


        return cnoVideoLikesVos;
    }

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */


    @Override
    public boolean queryByVnoCno(Integer con_no, Integer v_no) {
        if (this.tConVLikesDao.queryByVnoCno(con_no, v_no) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TConVLikes> queryAllByLimit(int offset, int limit) {
        return null;
    }


    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no, Integer v_no) {
        this.tConVLikesDao.insert(con_no, v_no);
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