package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 直播间(TLiveRooms)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class TLiveRooms implements Serializable {
    private static final long serialVersionUID = -22747175769004475L;
    /**
     * 直播间编号
     */
    private Integer room_no;
    /**
     * 直播间标题
     */
    private String room_title;
    /**
     * 主播（用户）编号
     */
    private Integer con_no;
    /**
     * 直播间封面
     */
    private String room_pic;
    /**
     * 直播间是否合法
     */
    private Boolean room_is_legal;
    /**
     * 是否开播
     */
    private Boolean is_live;

    /**
     * 直播间点赞数
     */
    private Integer room_likes;


    /**
     * 直播间地址
     */
    private String room_url;

    /**
     * 直播间串码
     */
    private String room_num;

}