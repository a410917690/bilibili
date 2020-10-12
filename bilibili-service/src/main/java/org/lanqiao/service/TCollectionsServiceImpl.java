package org.lanqiao.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TCollectionsDao;
import org.lanqiao.entity.TCollections;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏(TCollections)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:02
 */
@Service
@Component
public class TCollectionsServiceImpl implements TCollectionsService {
    @Resource
    private TCollectionsDao tCollectionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */


    @Override
    public List<TCollections> queryByCno(Integer con_no) {
        return tCollectionsDao.queryByCno(con_no);
    }

    @Override
    public List getVno(Integer con_no) {
        return tCollectionsDao.getVno(con_no);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TCollections> queryAllByLimit(int offset, int limit) {
        return this.tCollectionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public boolean insert(Integer con_no, Integer v_no) {
        if(this.tCollectionsDao.insert(con_no, v_no)>0){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 修改数据
     *
     * @param tCollections 实例对象
     * @return 实例对象
     */
//    @Override
//    public TCollections update(TCollections tCollections) {
//        this.tCollectionsDao.update(tCollections);
//        return this.queryByCno(tCollections.getCon_no());
//    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean delete(Integer con_no, Integer v_no) {
        if (this.tCollectionsDao.delete(con_no, v_no) > 0) {
            return true;
        } else {
            return false;
        }
    }
}