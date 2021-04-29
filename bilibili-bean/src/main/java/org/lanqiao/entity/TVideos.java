package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 视频(TVideos)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TVideos implements Serializable {
    private static final long serialVersionUID = 392484037862565419L;

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
     * 用户
     */
    private Integer con_no;
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
     * 投稿人name
     */
    private String name;

    /**
     * 视频标签
     */
    private List<String> tags;



}