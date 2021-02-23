package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TComCommentDao;
import org.lanqiao.entity.TComComment;
import org.lanqiao.service.TComCommentService;
import org.lanqiao.vo.TCommentVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论的评论(TComComment)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:04
 */
@Service
@Component
public class TComCommentServiceImpl implements TComCommentService {
    @Resource
    private TComCommentDao tComCommentDao;

    @Override
    public Integer queryComNo(Integer v_no, Integer con_no) {
        return tComCommentDao.queryComNo(v_no,con_no);
    }

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */


    @Override
    public List<TCommentVo> getComReply(Integer v_no, Integer con_no) {
        return tComCommentDao.queryComReply(v_no,con_no);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TComComment> queryAllByLimit(int offset, int limit) {
        return this.tComCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *

     * @return 实例对象
     */
    @Override
    public boolean insert(String com_com,Integer con_no,Integer com_no) {
        return this.tComCommentDao.insert(com_com,con_no,com_no)>0;
    }

    /**
     * 修改数据
     *
     * @param tComComment 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param comComNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer comComNo) {
        return this.tComCommentDao.deleteById(comComNo) > 0;
    }
}