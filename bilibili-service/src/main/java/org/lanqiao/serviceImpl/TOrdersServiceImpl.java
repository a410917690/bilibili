package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TIncomingDao;
import org.lanqiao.dao.TOrderDao;
import org.lanqiao.entity.TOrders;
import org.lanqiao.service.TOrdersService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.serviceImpl
 * @ClassName:TOrdersServiceImpl
 * @Description:
 * @Date 2021/2/18 11:25
 */
@Service
@Component
public class TOrdersServiceImpl implements TOrdersService {

    @Resource
    TOrderDao tOrderDao;

    @Resource
    TIncomingDao tIncomingDao;

    @Override
    public TOrders insertOrder(String o_no,Integer con_no, String i_name, Float money, Integer i_no) {

        tOrderDao.insertOrder(o_no, con_no, i_name, money, i_no);
        TOrders tOrders = tOrderDao.queryOrder(o_no);

        return tOrders;

    }

    @Override
    public Integer deleteOrder(String o_no) {
        return tOrderDao.deleteOrder(o_no);
    }

    @Override
    public Integer updateOrder(String o_no) {
        TOrders tOrders = tOrderDao.queryOrder(o_no);
        tIncomingDao.addIncoming(tOrders.getMoney());
        return tOrderDao.updateOrder(o_no);
    }

    @Override
    public TOrders queryOrder(String o_no) {
        return tOrderDao.queryOrder(o_no);
    }

    @Override
    public List<TOrders> queryAll() {
        return tOrderDao.queryAll();
    }

    @Override
    public TOrders queryCon(String o_no){
        return tOrderDao.queryCon(o_no);
    }

}
