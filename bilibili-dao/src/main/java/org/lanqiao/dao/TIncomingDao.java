package org.lanqiao.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.cache.RedisCache;
import org.springframework.stereotype.Repository;

//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TIncomingDao {

    @Insert("insert into t_income (money) values (#{money})")
    Integer addIncoming(Float money);

    @Select("select sum(money) from t_income")
    Float getAllIncome();

}
