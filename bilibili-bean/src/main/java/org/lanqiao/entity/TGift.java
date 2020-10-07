package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 礼物(TGift)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class TGift implements Serializable {
    private static final long serialVersionUID = 670131183093271125L;
    /**
     * 礼物编号
     */
    private Integer g_no;
    /**
     * 礼物名称
     */
    private String g_name;
    /**
     * 礼物价格
     */
    private Object g_price;



}