package org.lanqiao.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.lanqiao.entity.TCollections;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏(TCollections)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:22:12
 */
@Repository
@Mapper
public interface TCollectionsDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Select("select * from t_collections where con_no=#{con_no}")
    List<TCollections> queryByCno(Integer con_no);


    @Select("select v_no from t_collections where con_no=#{con_no}")
    List<Integer> getVno(Integer con_no);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TCollections> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tCollections 实例对象
     * @return 对象列表
     */

    List<TCollections> queryAll(TCollections tCollections);


    @Insert("insert into t_collections (con_no,v_no) values (#{con_no},#{v_no})")
    int insert(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no);

    /**
     * 修改数据
     *
     * @param tCollections 实例对象
     * @return 影响行数
     */
    int update(TCollections tCollections);

    /**
     * 通过主键删除数据
     *

     * @return 影响行数
     */
    @Delete("delete from t_collections where con_no=#{con_no} and v_no=#{v_no}")
    int delete(@Param("con_no") Integer con_no,@Param("v_no") Integer v_no);

}