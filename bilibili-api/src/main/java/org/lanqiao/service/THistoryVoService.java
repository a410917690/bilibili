package org.lanqiao.service;


import org.lanqiao.vo.THistoryVo;

import java.util.List;

public interface THistoryVoService {

    List<THistoryVo> getHistory(Integer con_no);

}
