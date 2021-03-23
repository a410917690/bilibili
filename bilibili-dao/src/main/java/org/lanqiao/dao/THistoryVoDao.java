package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;


import org.lanqiao.cache.RedisCache;
import org.lanqiao.vo.THistoryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface THistoryVoDao {
    @Select("select * from t_videos v,(select v_no from t_history h where con_no=#{con_no}) n where v.v_no = n.v_no")
    List<THistoryVo> selectTHistoryByCon(Integer con_no);




}
