package org.lanqiao.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.entity.TFocus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TFocusDao {

    @Insert("insert into t_focus (con_no,fo_fo_no) values(#{con_no},#{fo_fo_no})")
    int addFocus(Integer con_no,Integer fo_fo_no);

    @Select("select * from t_focus where con_no=#{con_no} and fo_fo_no=#{fo_fo_no}")
    TFocus isFocus(Integer con_no, Integer fo_fo_no);

    @Select("select * from t_focus where con_no=#{con_no} and fo_fo_no=#{fo_fo_no}")
    TFocus getFocus(Integer con_no, Integer fo_fo_no);

    @Delete("delete from t_focus where con_no=#{con_no} and fo_fo_no=#{fo_fo_no}")
    int deleteFocus(Integer con_no,Integer fo_fo_no);

    @Select("select fo_fo_no from t_focus where con_no=#{con_no}")
    List<Integer> getAllFocusByCon(Integer con_no);

    @Select("SELECT count(*) a FROM t_focus WHERE fo_fo_no = #{fo_fo_no}")
    Integer getNumBF(Integer fo_fo_no);

    @Select("SELECT count(*) b FROM t_focus WHERE con_no = #{fo_fo_no}")
    Integer getNumF(Integer fo_fo_no);

    @Select("SELECT count( v_likes ) c FROM t_videos WHERE con_no = #{fo_fo_no}")
    Integer getNumL(Integer fo_fo_no);

    @Select("select * from t_consumers where con_no in (select fo_fo_no from t_focus where con_no=#{con_no})")
    List<TConsumers> getAllFocusConsumerByCon(Integer con_no);

    @Select("select * from t_consumers where con_no=#{fo_fo_no}")
    TConsumers getFocusConsumerByCon(Integer fo_fo_no);

}
