package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 收藏(TCollections)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:11:35
 */
@Data
public class TCollections implements Serializable {
    private static final long serialVersionUID = -83111155603531395L;
    /**
     * 收藏编号
     */
    private Integer col_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 视频编号
     */
    private Integer v_no;



}