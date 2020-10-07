package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 视频标签(TVTag)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TVTag implements Serializable {
    private static final long serialVersionUID = 814296043650004262L;
    /**
     * 视频标签编号
     */
    private Integer v_tag_no;
    /**
     * 视频编号
     */
    private Integer v_no;
    /**
     * 标签编号
     */
    private Integer t_no;




}