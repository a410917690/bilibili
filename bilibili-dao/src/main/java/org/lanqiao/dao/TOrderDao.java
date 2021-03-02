package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.TOrders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.dao
 * @ClassName:TOrderDao
 * @Description:
 * @Date 2021/2/17 18:56
 */
@Repository
@Mapper
public interface TOrderDao {

    @Insert("insert into t_orders(o_no,con_no,i_name,money,i_no) values (#{o_no},#{con_no},#{i_name},#{money},#{i_no})")
    Integer insertOrder(Long o_no,Integer con_no,String i_name,Float money,Integer i_no);

    @Delete("delete from t_orders where o_no=#{o_no}")
    Integer deleteOrder(Long o_no);

    @Update("update t_orders set o_status=1 where o_no=#{o_no}")
    Integer updateOrder(Long o_no);

    @Select("select * from t_orders where o_no=#{o_no}")
    TOrders queryOrder(Long o_no);

    @Select("select con_no from t_orders where o_no=#{o_no}")
    TOrders queryCon(Long o_no);

    @Select("select * from t_orders")
    List<TOrders> queryAll();

}
