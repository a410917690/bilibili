package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

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




}