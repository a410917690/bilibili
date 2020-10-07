package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 评论的评论(TComComment)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:17
 */
@Data
public class TComComment implements Serializable {
    private static final long serialVersionUID = 567574000810585342L;
    /**
     * 编号
     */
    private Integer com_com_no;
    /**
     * 被评论的评论编号
     */
    private Integer com_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 评论
     */
    private String com_com;


}