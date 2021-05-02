package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CnoVideoLikesVo implements Serializable {
    private static final long serialVersionUID = 567574000810585344L;

    /**
     * 点赞编号
     */
    private Integer con_v_likes_no;


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

    /**
     * 视频标签
     */
    private List<String> tagNames;
}
