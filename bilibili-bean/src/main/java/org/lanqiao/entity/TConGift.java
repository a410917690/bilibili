package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户礼物(TConGift)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:44
 */
@Data

public class TConGift implements Serializable {
    private static final long serialVersionUID = 542320270270113771L;
    /**
     * 编号
     */
    private Integer con_g_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 礼物编号
     */
    private Integer g_no;




}