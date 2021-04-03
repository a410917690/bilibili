package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class THistoryVo implements Serializable {
    private static final long serialVersionUID = 792526065938981392L;

    /**
     * 历史记录编号
     */
    private Integer his_no;

    /**
     * 历史记录时间
     */
    private String watch_date;


    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 视频编号
     */
    private Integer v_no;

    /**
     * 视频标题
     */
    private String v_title;

    /**
     * 播放量
     */
    private Integer v_amount_of_play;

    /**
     * 视频地址
     */
    private String v_url;


    /**
     * 发布该视频的用户编号
     */
    private Integer blong_con_no;

    /**
     * 点赞数
     */
    private Integer v_likes;

    /**
     * 视频封面
     */
    private String v_pic;

    /**
     * 视频投币数
     */
    private Integer v_coins;

    /**
     * 视频被举报次数
     */
    private Integer v_reports;

    /**
     * 视频是否合法
     */
    private boolean v_legal;


}

