package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.cache.RedisCache;
import org.springframework.stereotype.Repository;

@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface UpdateCoinsDao {

    @Update("update t_consumers set coins=coins - 1 where con_no=#{con_no} and coins > 0")
    boolean updateCno(Integer cno_no);

    @Update("update t_videos set v_coins=v_coins + 1 where v_no=#{v_no}")
    int updateVno(Integer v_no);

    @Update("update t_consumers set coins=coins + 1 where con_no=(select con_no from t_videos where v_no=#{v_no})")
    int updategetCoin(Integer v_no);
}
