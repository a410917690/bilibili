package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TItems;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.dao
 * @ClassName:TItemsDao
 * @Description:
 * @Date 2021/2/17 18:56
 */
@Repository
@Mapper
public interface TItemsDao {

    @Select("select * from t_items")
    public List<TItems> queryAll();

    @Select("select i_name from t_items where i_no=#{i_no}")
    public String queryName(Integer i_no);

    @Select("select per_price from t_items where i_no=#{i_no}")
    public Float queryMoney(Integer i_no);

    @Select("select i_no from t_items where i_name=#{i_name}")
    public Float queryIno(Integer i_name);

}
