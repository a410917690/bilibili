package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.dao.TCommentsDao;
import org.lanqiao.entity.TComments;
import org.lanqiao.service.TCommentsService;
import org.lanqiao.vo.CommentVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论(TComments)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 11:30:05
 */
@Service
@Component
public class TCommentsServiceImpl implements TCommentsService {
    @Resource
    private TCommentsDao tCommentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param comNo 主键
     * @return 实例对象
     */
    @Override
    public TComments queryById(Integer comNo) {
        return this.tCommentsDao.queryById(comNo);
    }

    @Override
    public Object queryAllByVno(int pageNum, int pageSize,Integer v_no) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommentVo> list = tCommentsDao.queryAllByVno(v_no);
        return new PageInfo<>(list);
    }

    /**
     * 查询多条数据

    /**
     * 新增数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    @Override
    public List<CommentVo> insert(TComments tComments) {
        this.tCommentsDao.insert(tComments);
        return this.tCommentsDao.queryAllByVno(tComments.getV_no());
    }

    /**
     * 修改数据
     *
     * @param tComments 实例对象
     * @return 实例对象
     */
    @Override
    public TComments update(TComments tComments) {
        this.tCommentsDao.update(tComments);
        return this.queryById(tComments.getCom_no());
    }

    @Override
     public String deleteComment(Integer v_no,Integer con_no) {
        this.tCommentsDao.deleteByVno(v_no,con_no);
        return "删除成功！";
    }


    /**
     * 通过主键删除数据
     *
     * @param comNo 主键
     * @return 是否成功
     */

}