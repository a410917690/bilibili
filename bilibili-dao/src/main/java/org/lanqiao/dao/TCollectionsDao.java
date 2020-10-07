package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
     * @param colNo 主键
     * @return 实例对象
     */
    @Select("select * from t_collections where col_no=#{colNo}")
    TCollections queryById(Integer colNo);

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

    /**
     * 新增数据
     *
     * @param tCollections 实例对象
     * @return 影响行数
     */
    int insert(TCollections tCollections);

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
     * @param colNo 主键
     * @return 影响行数
     */
    int deleteById(Integer colNo);

}