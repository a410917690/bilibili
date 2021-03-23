package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 评论(TComments)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:30
 */
@Data
public class TComments implements Serializable {
    private static final long serialVersionUID = -75987512999959830L;
    /**
     * 评论编号
     */
    private Integer com_no;
    /**
     * 视频编号
     */
    private Integer v_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 评论
     */
    private String con_comment;

    private Timestamp com_time;


}