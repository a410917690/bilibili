package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 来到直播间的用户(TRoomCon)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TRoomCon implements Serializable {
    private static final long serialVersionUID = -32792943568570458L;
    /**
     * 编号
     */
    private Integer room_con_no;
    /**
     * 直播间编号
     */
    private Integer room_no;
    /**
     * 来到直播间的用户编号
     */
    private Integer con_no;




}