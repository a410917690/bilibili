package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TLLRooms implements Serializable {
    private static final long serialVersionUID = -22747175769004478L;

    /**
     * 点赞编号
     */
    private Integer llr_no;

    /**
     * 直播间编号
     */
    private Integer room_no;

    /**
     * 点赞用户编号
     */
    private Integer con_no;

    /**
     * 直播间点赞数
     */
    private Integer llr_likes;
}
