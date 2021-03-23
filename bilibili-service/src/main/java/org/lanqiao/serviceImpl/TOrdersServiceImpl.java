package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TConsumersDao;
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

    @Resource
    TConsumersDao tConsumersDao;

    @Override
    public TOrders insertOrder(Long o_no,Integer con_no, String i_name, Float money, Integer i_no) {

        tOrderDao.insertOrder(o_no, con_no, i_name, money, i_no);
        TOrders tOrders = tOrderDao.queryOrder(o_no);

        return tOrders;

    }

    @Override
    public Integer deleteOrder(Long o_no) {
        return tOrderDao.deleteOrder(o_no);
    }

    @Override
    public Integer updateOrder(Long o_no) {
        TOrders tOrders = tOrderDao.queryOrder(o_no);
        tIncomingDao.addIncoming(tOrders.getMoney());
        return tOrderDao.updateOrder(o_no);
    }

    @Override
    public TOrders queryOrder(Long o_no) {
        return tOrderDao.queryOrder(o_no);
    }

    @Override
    public List<TOrders> queryAll() {
        return tOrderDao.queryAll();
    }

    @Override
    public TOrders queryCon(Long o_no){
        return tOrderDao.queryCon(o_no);
    }

    @Override
    public int to1Vip(Integer con_no) {
        return tConsumersDao.to1Vip(con_no);
    }

//    @Override
//    public int to3Vip(Integer con_no) {
//        return tConsumersDao.to3Vip(con_no);
//    }
//
//    @Override
//    public int to12Vip(Integer con_no) {
//        return tConsumersDao.to12Vip(con_no);
//    }

}
