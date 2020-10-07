package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.TFan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 番剧(TFan)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:23:47
 */
@Repository
@Mapper
public interface TFanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fanNo 主键
     * @return 实例对象
     */
    @Select("select * from t_fan where fan_title=#{fan_title}")
    TFan queryById(String fan_title);

    @Select("select * from t_fan")
    List<TFan> queryAllByPage();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFan 实例对象
     * @return 对象列表
     */
    List<TFan> queryAll(TFan tFan);

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    int insert(TFan tFan);

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    int update(TFan tFan);

    /**
     * 通过主键删除数据
     *
     * @param fanNo 主键
     * @return 影响行数
     */
    int deleteById(Integer fanNo);

}