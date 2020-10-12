package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户点赞过 的视频(TConVLikes)实体类
 *
 * @author makejava
 * @since 2020-10-11 15:35:22
 */
@Data
public class TConVLikes implements Serializable {
    private static final long serialVersionUID = 376982062424632815L;
    /**
     * 编号
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



}