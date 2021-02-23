package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TItemsDao;
import org.lanqiao.dao.TLiveRoomsDao;
import org.lanqiao.entity.TItems;
import org.lanqiao.service.TItemsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.serviceImpl
 * @ClassName:TItemsServiceImpl
 * @Description:
 * @Date 2021/2/18 11:24
 */
@Service
@Component
public class TItemsServiceImpl implements TItemsService{

    @Resource
    private TItemsDao tItemsDao;

    @Override
    public List<TItems> queryAll() {
        return tItemsDao.queryAll();
    }

    @Override
    public String queryName(Integer i_no) {
        return tItemsDao.queryName(i_no);
    }

    @Override
    public Float queryMoney(Integer i_no) {
        return tItemsDao.queryMoney(i_no);
    }

    @Override
    public Float queryIno(Integer i_name) {
        return tItemsDao.queryIno(i_name);
    }
}
