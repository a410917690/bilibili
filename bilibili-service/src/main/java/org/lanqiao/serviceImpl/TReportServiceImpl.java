package org.lanqiao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.lanqiao.dao.TReportDao;
import org.lanqiao.entity.TReport;
import org.lanqiao.service.TReportService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class TReportServiceImpl implements TReportService {

    @Resource
    TReportDao tReportDao;

    /**
     * 通过用户con_no查询此用户举报的各种信息
     */
    @Override
    public List<TReport> getTreportByConNo(Integer con_no) {
        return this.tReportDao.getTreportByConNo(con_no);
    }

    /**
     * 查询某用户是否举报过某视频
     */
    @Override
    public boolean getTreportByConNoV(Integer con_no, Integer v_no) {
        if (this.tReportDao.getTreportByConNoV(con_no,v_no) == null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 查询某用户是否举报过某直播间
     */
    @Override
    public boolean getTreportByConNoR(Integer con_no, Integer room_no) {
        if (this.tReportDao.getTreportByConNoR(con_no,room_no) == null){
            return false;
        }else {
            return true;
        }
    }
}
