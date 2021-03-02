package org.lanqiao.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.entity.TFocus;

import java.util.List;

public interface TFocusService {

    int addFocus(Integer con_no,Integer fo_fo_no);

    TConsumers getFocus(Integer fo_fo_no);

    TFocus isFocus(Integer con_no,Integer fo_fo_no);

    int deleteFocus(Integer con_no,Integer fo_fo_no);

    List<Integer> getAllFocusByCon(Integer con_no);

    List<TConsumers> getAllFocusConsumerByCon(Integer con_no);

    Integer getNumBF(Integer fo_fo_no);

    Integer getNumF(Integer fo_fo_no);

    Integer getNumL(Integer fo_fo_no);

}
