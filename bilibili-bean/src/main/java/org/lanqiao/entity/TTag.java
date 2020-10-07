package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 标签(TTag)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TTag implements Serializable {
    private static final long serialVersionUID = 604018694831173063L;
    /**
     * 标签编号
     */
    private Integer t_no;
    /**
     * 标签名称
     */
    private String t_name;



}