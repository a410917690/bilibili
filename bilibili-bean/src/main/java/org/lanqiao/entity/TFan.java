package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 番剧(TFan)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class TFan implements Serializable {
    private static final long serialVersionUID = -42214596319235939L;
    /**
     * 番剧编号
     */
    private Integer fan_no;
    /**
     * 标题
     */
    private String fan_title;
    /**
     * 番剧地址
     */
    private String fan_url;
    /**
     * 管理员编号
     */
    private Integer m_no;
    /**
     * 番剧封面
     */
    private String fan_pic;




}