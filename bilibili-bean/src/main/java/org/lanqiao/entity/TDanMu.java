package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 弹幕(TDanMu)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class TDanMu implements Serializable {
    private static final long serialVersionUID = -89628499829882450L;
    /**
     * 弹幕编号
     */
    private Integer dan_no;
    /**
     * 视频编号
     */
    private Integer v_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 弹幕内容
     */
    private String text;
    /**
     * 弹幕位置
     */
    private Integer position;
    /**
     * 创建弹幕时间
     */
    private Integer time;

    private String color;

    private Integer size;



}