package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.THistoryDao;
import org.lanqiao.dao.THistoryVoDao;
import org.lanqiao.entity.THistory;
import org.lanqiao.service.THistoryService;
import org.lanqiao.service.TVideosService;
import org.lanqiao.vo.THistoryVo;
import org.lanqiao.vo.VideoVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 观看历史(THistory)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class THistoryServiceImpl implements THistoryService {
    @Resource
    private THistoryDao tHistoryDao;

    @Resource
    private THistoryVoDao tHistoryVoDao;

    @Resource
    private TVideosService tVideosService;

    @Override
    public THistory queryById(Integer hisNo) {
        return null;
    }

    @Override
    public List<THistory> queryByCno(Integer cno_no) {
        return this.tHistoryDao.queryAllHisBycon(cno_no);
    }

    @Override
    public Set<THistoryVo> getHistory(Integer con_no) throws ParseException {
        List<THistory> tHistories = this.tHistoryDao.queryAllHisBycon(con_no);
        List<Integer> v_nos = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer,String> map1 = new HashMap<>();
        Set<THistoryVo> tHistoryVos = new HashSet<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (THistory tHistory : tHistories) {
            v_nos.add(tHistory.getV_no());
            map.put(tHistory.getV_no(), tHistory.getHis_no());

//            String dateStr = tHistory.getWatch_date().toString();
//            Date date = simpleDateFormat.parse(dateStr);

            map1.put(map.get(tHistory.getV_no()),simpleDateFormat.format(tHistory.getWatch_date()));
        }

        for (Integer vNo : v_nos) {
            VideoVo videoVo = tVideosService.queryById(vNo);
            THistoryVo tHistoryVo = new THistoryVo();
            tHistoryVo.setBlong_con_no(videoVo.getCon_no());
            tHistoryVo.setCon_no(con_no);
            tHistoryVo.setHis_no(map.get(vNo));
            tHistoryVo.setV_amount_of_play(videoVo.getV_amount_of_play());
            tHistoryVo.setV_coins(videoVo.getV_coins());
            tHistoryVo.setV_legal(videoVo.isV_legal());
            tHistoryVo.setV_likes(videoVo.getV_likes());
            tHistoryVo.setV_reports(videoVo.getV_reports());
            tHistoryVo.setV_no(videoVo.getV_no());
            tHistoryVo.setV_pic(videoVo.getV_pic());
            tHistoryVo.setV_title(videoVo.getV_title());
            tHistoryVo.setV_url(videoVo.getV_url());

            tHistoryVo.setWatch_date(map1.get(tHistoryVo.getHis_no()));


            tHistoryVos.add(tHistoryVo);
        }
        return tHistoryVos;
    }

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */


    @Override
    public List<THistory> queryAllHisByCon(Integer con_no) {
        return tHistoryDao.queryAllHisBycon(con_no);
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
     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no, Integer v_no) {
        if (this.tHistoryDao.insert(con_no, v_no) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改数据
     *
     * @param tHistory 实例对象
     * @return 实例对象
     */
    @Override
    public THistory update(THistory tHistory) {
        this.tHistoryDao.update(tHistory);
        return this.queryById(tHistory.getHis_no());
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer con_no, Integer v_no) {
        return this.tHistoryDao.deleteById(con_no, v_no) > 0;
    }
}