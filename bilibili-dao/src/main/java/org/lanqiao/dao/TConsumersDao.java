package org.lanqiao.dao;

import org.apache.ibatis.annotations.*;
import org.lanqiao.cache.RedisCache;
import org.lanqiao.entity.TConsumers;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户(ConsumersVo)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:27:33
 */
//@CacheNamespace(implementation = RedisCache.class)
@Repository
@Mapper
public interface TConsumersDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_consumers where name=#{name}")
    TConsumers queryByName(String name);

    @Select("select * from t_consumers where name=#{name} and password=#{password}")
    TConsumers queryByNameAndPwd(@Param("name") String name,@Param("password") String password);

    @Select("select * from t_consumers where con_no=#{con_no}")
    TConsumers queryByCno(Integer con_no);

    @Select("select * from t_consumers where tel_num=#{tel_num}")
    TConsumers queryByTel(String tel_num);

    @Select("select * from t_consumers where mail=#{mail}")
    TConsumers queryByMail(String mail);

//    @Select("select c.*,r.role_name from t_consumers c ,t_roles r  where c.role_no=r.role_no")
//    ConsumersVo getConsumersVo();

    @Select("select role_name from t_roles where role_no in (select role_no from t_consumers where con_no=#{con_no});")
    String getRoleName(Integer con_no);


    @Select("select * from t_consumers order by con_no")
    public List<TConsumers> getListByPage();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TConsumers> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConsumers 实例对象
     * @return 对象列表
     */
    @Select("select * from t_consumers where name = #{name} or tel_num = #{tel_num}")
    List<TConsumers> queryAll(TConsumers tConsumers);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConsumers 实例对象
     * @return 对象列表
     */
    @Select("select * from t_consumers where tel_num = #{tel_num}")
    List<TConsumers> queryByTelNum(TConsumers tConsumers);

    /**
     * 新增用户
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    @Insert("insert into t_consumers (name,password,mail) values (#{name},#{password},#{mail})")
    int insert(TConsumers tConsumers);

    @Update("update t_consumers set pic=#{pic} where name=#{name}")
    int uploadPic(@Param("pic") byte[] pic,@Param("name") String name);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    @Update("update t_consumers set password=#{password},role_no=#{role_no},tel_num=#{tel_num},coins=#{coins},member_deadline=#{member_deadline},con_is_legal=#{con_is_legal} where con_no=#{con_no}")
    int update(TConsumers tConsumers);

    /**
     * 通过主键删除数据
     * @return 影响行数
     */
    @Delete("delete from t_consumers where con_no=#{con_no}")
    int deleteById(Integer con_no);

    @Select("select password from t_consumers where name=#{name}")
    String findPwd(String name);

    @Update("update t_consumers set password=#{password} where name=#{name}")
    Integer updatePwd(String name,String password);

    @Update("update t_consumers set name=#{newName},age=#{age},tele_num=#{tele_num},password=#{newPwd} where name=#{name} and password=#{password}")
    Integer updateDetail(String newName,String name,String tele_num,Integer age,String password,String newPwd);

    @Update("update t_consumers set report_num = report_num + 1 where con_no=#{con_no}")
    int addReportNum(Integer con_no);

    @Update("update t_consumers set con_is_legal = 0 where con_no=#{con_no} and report_num > 30")
    int toIllegal(Integer con_no);

    @Update("update t_consumers set role_no=4 where con_no=#{con_no}")
    int to1Vip(Integer con_no);

//    @Update("update t_consumers set role_no=5,member_deadline=member_deadline+90 where con_no=#{con_no}")
//    int to3Vip(Integer con_no);
//
//    @Update("update t_consumers set role_no=6,member_deadline=member_deadline+365 where con_no=#{con_no}")
//    int to12Vip(Integer con_no);

    @Update("update t_consumers set role_no=1,member_deadline=0 where con_no=#{con_no}")
    int toCommon(Integer con_no);

    @Update("update t_consumers set member_deadline=#{member_deadline} where con_no=#{con_no} and member_deadline>0")
    int decrMemberDeadline(Integer member_deadline,Integer con_no);
//
//    @Select("select be_vip_time from t_consumers where con_no=#{con_no} and member_deadline>0")
//    Date getBeVipTime(Integer con_no);

}