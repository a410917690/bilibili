package org.lanqiao.service;


import org.lanqiao.entity.TReport;

import java.util.List;

public interface TReportService {

    /**
     * 通过用户con_no查询此用户举报的各种信息
     */
    List<TReport> getTreportByConNo(Integer con_no);

    /**
     * 查询某用户是否举报过某视频
     */
    boolean getTreportByConNoV(Integer con_no,Integer v_no);

    /**
     * 查询某用户是否举报过某直播间
     */
    boolean getTreportByConNoR(Integer con_no,Integer room_no);
}
