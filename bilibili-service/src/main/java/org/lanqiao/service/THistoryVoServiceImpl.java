package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.THistoryVoDao;
import org.lanqiao.vo.THistoryVo;


import javax.annotation.Resource;
import java.util.List;


@Service
public class THistoryVoServiceImpl implements THistoryVoService {
    @Resource
    THistoryVoDao tHistoryVoDao;


    @Override
    public List<THistoryVo> getHistory(Integer con_no) {
        return tHistoryVoDao.selectTHistoryByCon(con_no);
    }
}
