package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 直播间收到的用户礼物(TRoomGift)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TRoomGift implements Serializable {
    private static final long serialVersionUID = 718905257210839271L;
    /**
     * 编号
     */
    private Integer room_g_no;
    /**
     * 直播间编号
     */
    private Integer room_no;
    /**
     * 刷礼物的用户编号
     */
    private Integer room_con_no;
    /**
     * 礼物编号
     */
    private Integer g_no;



}