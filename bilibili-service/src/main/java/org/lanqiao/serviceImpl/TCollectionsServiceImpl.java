package org.lanqiao.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TCollectionsDao;
import org.lanqiao.entity.TCollections;
import org.lanqiao.service.TCollectionsService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.vo.CollectionsVideoVo;
import org.lanqiao.vo.VideoVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 收藏(TCollections)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:02
 */
@Service
@Component
public class TCollectionsServiceImpl implements TCollectionsService {
    @Resource
    private TCollectionsDao tCollectionsDao;

    @Resource
    private TVideosService tVideosService;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */


    @Override
    public Object queryByCno(Integer con_no,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TCollections> tCollections = tCollectionsDao.queryByCno(con_no);
        List<Integer> v_nos = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        List<CollectionsVideoVo> collectionsVideoVos = new ArrayList<>();
        for (TCollections tCollections1 : tCollections) {
            v_nos.add(tCollections1.getV_no());
            map.put(tCollections1.getV_no(),tCollections1.getCol_no());
        }

        for (Integer vNo : v_nos) {
            VideoVo videoVo = tVideosService.queryById(vNo);
            CollectionsVideoVo collectionsVideoVo = new CollectionsVideoVo();
            collectionsVideoVo.setCol_no(map.get(vNo));
            collectionsVideoVo.setBlong_con_no(videoVo.getCon_no());
            collectionsVideoVo.setCon_no(con_no);
            collectionsVideoVo.setV_amount_of_play(videoVo.getV_amount_of_play());
            collectionsVideoVo.setV_coins(videoVo.getV_coins());
            collectionsVideoVo.setV_legal(videoVo.isV_legal());
            collectionsVideoVo.setV_likes(videoVo.getV_likes());
            collectionsVideoVo.setV_no(videoVo.getV_no());
            collectionsVideoVo.setV_pic(videoVo.getV_pic());
            collectionsVideoVo.setV_reports(videoVo.getV_reports());
            collectionsVideoVo.setV_title(videoVo.getV_title());
            collectionsVideoVo.setV_url(videoVo.getV_url());

            collectionsVideoVos.add(collectionsVideoVo);
        }
        return new PageInfo<>(collectionsVideoVos);

    }

    @Override
    public List<CollectionsVideoVo> queryAllCollections(Integer con_no) {
        List<TCollections> tCollections = tCollectionsDao.queryByCno(con_no);
        List<Integer> v_nos = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        List<CollectionsVideoVo> collectionsVideoVos = new ArrayList<>();
        for (TCollections tCollections1 : tCollections) {
            v_nos.add(tCollections1.getV_no());
            map.put(tCollections1.getV_no(),tCollections1.getCol_no());
        }

        for (Integer vNo : v_nos) {
            VideoVo videoVo = tVideosService.queryById(vNo);
            CollectionsVideoVo collectionsVideoVo = new CollectionsVideoVo();
            collectionsVideoVo.setCol_no(map.get(vNo));
            collectionsVideoVo.setBlong_con_no(videoVo.getCon_no());
            collectionsVideoVo.setCon_no(con_no);
            collectionsVideoVo.setV_amount_of_play(videoVo.getV_amount_of_play());
            collectionsVideoVo.setV_coins(videoVo.getV_coins());
            collectionsVideoVo.setV_legal(videoVo.isV_legal());
            collectionsVideoVo.setV_likes(videoVo.getV_likes());
            collectionsVideoVo.setV_no(videoVo.getV_no());
            collectionsVideoVo.setV_pic(videoVo.getV_pic());
            collectionsVideoVo.setV_reports(videoVo.getV_reports());
            collectionsVideoVo.setV_title(videoVo.getV_title());
            collectionsVideoVo.setV_url(videoVo.getV_url());

            collectionsVideoVos.add(collectionsVideoVo);
        }
        return collectionsVideoVos;
    }


    @Override
    public List getVno(Integer con_no) {
        return tCollectionsDao.getVno(con_no);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TCollections> queryAllByLimit(int offset, int limit) {
        return this.tCollectionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no, Integer v_no) {
        if (this.tCollectionsDao.insert(con_no, v_no) > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 修改数据
     *
     * @param tCollections 实例对象
     * @return 实例对象
     */
//    @Override
//    public TCollections update(TCollections tCollections) {
//        this.tCollectionsDao.update(tCollections);
//        return this.queryByCno(tCollections.getCon_no());
//    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean delete(Integer con_no, Integer v_no) {
        if (this.tCollectionsDao.delete(con_no, v_no) > 0) {
            return true;
        } else {
            return false;
        }
    }
}