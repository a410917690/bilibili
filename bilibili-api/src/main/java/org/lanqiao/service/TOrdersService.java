package org.lanqiao.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.TOrders;

import java.util.Date;
import java.util.List;

public interface TOrdersService {

    TOrders insertOrder(Long o_no,Integer con_no,String i_name,Float money,Integer i_no);

    Integer deleteOrder(Long o_no);

    Integer updateOrder(Long o_no);

    TOrders queryOrder(Long o_no);

    List<TOrders> queryAll();

    TOrders queryCon(Long o_no);

    int to1Vip(Integer con_no);

    int to3Vip(Integer con_no);

    int to12Vip(Integer con_no);

}
