package org.lanqiao.service;

import org.lanqiao.entity.TVTag;

import java.util.List;

/**
 * 视频标签(TVTag)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 11:28:30
 */
public interface TVTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param vTagNo 主键
     * @return 实例对象
     */
    TVTag queryById(Integer vTagNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TVTag> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tVTag 实例对象
     * @return 实例对象
     */
    TVTag insert(TVTag tVTag);

    /**
     * 修改数据
     *
     * @param tVTag 实例对象
     * @return 实例对象
     */
    TVTag update(TVTag tVTag);

    /**
     * 通过主键删除数据
     *
     * @param vTagNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer vTagNo);

}