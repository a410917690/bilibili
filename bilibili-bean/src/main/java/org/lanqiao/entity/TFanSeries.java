package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 剧集(TFanSeries)实体类
 *
 * @author makejava
 * @since 2020-10-09 18:59:06
 */
@Data
public class TFanSeries implements Serializable {
    private static final long serialVersionUID = -15595370546684368L;
    /**
     * 番剧集数编号
     */
    private Integer fan_series_no;
    /**
     * 番剧编号
     */
    private Integer fan_no;
    /**
     * 番剧集数
     */
    private Integer series_num;
    /**
     * 每集封面
     */
    private String series_pic;
    /**
     * 每集标题
     */
    private String series_title;
    /**
     * 视频地址
     */
    private String series_url;




}