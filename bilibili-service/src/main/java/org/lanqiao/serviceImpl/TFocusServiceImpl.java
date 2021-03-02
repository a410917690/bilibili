package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TFocusDao;
import org.lanqiao.entity.TConsumers;
import org.lanqiao.entity.TFocus;
import org.lanqiao.service.TFocusService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.serviceImpl
 * @ClassName:TFocusServiceImpl
 * @Description:
 * @Date 2021/2/23 9:31
 */
@Service
@Component
public class TFocusServiceImpl implements TFocusService {

    @Resource
    TFocusDao tFocusDao;

    @Override
    public int addFocus(Integer con_no, Integer fo_fo_no) {
        return tFocusDao.addFocus(con_no, fo_fo_no);
    }

    @Override
    public TFocus isFocus(Integer con_no,Integer fo_fo_no) {
        return tFocusDao.isFocus(con_no,fo_fo_no);
    }

    @Override
    public TConsumers getFocus(Integer fo_fo_no) {
        return tFocusDao.getFocusConsumerByCon(fo_fo_no);
    }

    @Override
    public int deleteFocus(Integer con_no, Integer fo_fo_no) {
        return tFocusDao.deleteFocus(con_no, fo_fo_no);
    }

    @Override
    public List<Integer> getAllFocusByCon(Integer con_no) {
        return tFocusDao.getAllFocusByCon(con_no);
    }

    @Override
    public List<TConsumers> getAllFocusConsumerByCon(Integer con_no) {

        return tFocusDao.getAllFocusConsumerByCon(con_no);
    }

    @Override
    public Integer getNumBF(Integer fo_fo_no) {
        return this.tFocusDao.getNumBF(fo_fo_no);
    }

    @Override
    public Integer getNumF(Integer fo_fo_no) {
        return this.tFocusDao.getNumF(fo_fo_no);
    }

    @Override
    public Integer getNumL(Integer fo_fo_no) {
        return this.tFocusDao.getNumL(fo_fo_no);
    }
}
