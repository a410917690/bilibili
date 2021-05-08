package org.lanqiao.service;


import org.lanqiao.vo.THistoryVo;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface THistoryVoService {

    LinkedList<THistoryVo> getHistory(Integer con_no);

}
