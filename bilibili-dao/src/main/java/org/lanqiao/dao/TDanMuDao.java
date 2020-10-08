package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.TDanMu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 弹幕(TDanMu)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 11:23:40
 */
@Repository
@Mapper
public interface TDanMuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param danNo 主键
     * @return 实例对象
     */
    TDanMu queryById(Integer danNo);



    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TDanMu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tDanMu 实例对象
     * @return 对象列表
     */
    List<TDanMu> queryAll(TDanMu tDanMu);

    /**
     * 新增数据
     *
     * @param tDanMu 实例对象
     * @return 影响行数
     */
    int insert(TDanMu tDanMu);

    /**
     * 修改数据
     *
     * @param tDanMu 实例对象
     * @return 影响行数
     */
    int update(TDanMu tDanMu);

    /**
     * 通过主键删除数据
     *
     * @param danNo 主键
     * @return 影响行数
     */
    int deleteById(Integer danNo);

}