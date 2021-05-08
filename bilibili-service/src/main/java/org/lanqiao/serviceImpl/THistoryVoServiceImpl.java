package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.THistoryVoDao;
import org.lanqiao.service.THistoryVoService;
import org.lanqiao.vo.THistoryVo;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Service
@Component
public class THistoryVoServiceImpl implements THistoryVoService {
    @Resource
    THistoryVoDao tHistoryVoDao;


    @Override
    public LinkedList<THistoryVo> getHistory(Integer con_no) {
        return tHistoryVoDao.selectTHistoryByCon(con_no);
    }
}
