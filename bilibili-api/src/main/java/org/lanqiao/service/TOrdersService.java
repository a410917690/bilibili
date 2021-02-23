package org.lanqiao.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.TOrders;

import java.util.List;

public interface TOrdersService {

    TOrders insertOrder(String o_no,Integer con_no,String i_name,Float money,Integer i_no);

    Integer deleteOrder(String o_no);

    Integer updateOrder(String o_no);

    TOrders queryOrder(String o_no);

    List<TOrders> queryAll();

    TOrders queryCon(String o_no);

}
