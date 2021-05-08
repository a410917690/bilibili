package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;


import org.lanqiao.cache.RedisCache;
import org.lanqiao.vo.THistoryVo;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface THistoryVoDao {
    @Select("select * from t_videos a right join (select v_no,his_no from t_history b where b.con_no=#{con_no} order by his_no desc) c on a.v_no=c.v_no")
    LinkedList<THistoryVo> selectTHistoryByCon(Integer con_no);




}
