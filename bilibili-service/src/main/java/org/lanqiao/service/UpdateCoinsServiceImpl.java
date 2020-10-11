package org.lanqiao.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.UpdateCoinsDao;
import org.lanqiao.vo.UpdateCoinsVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Service
@Component
public class UpdateCoinsServiceImpl implements UpdateCoinsService {
    @Resource
    private UpdateCoinsDao updateCoinsDao;

    @Override
    public boolean update(Integer con_no, Integer v_no) {
        boolean falg = this.updateCoinsDao.updateCno(con_no);
        if (falg == true) {
            this.updateCoinsDao.updateVno(v_no);
            this.updateCoinsDao.updategetCoin(v_no);
            return true;
        } else {
            return false;
        }
    }
}
