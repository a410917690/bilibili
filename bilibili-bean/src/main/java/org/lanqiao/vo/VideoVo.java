package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:VideoVo
 * @Description:
 * @Date 2021/3/14 21:53
 */
@Data
public class VideoVo implements Serializable {
    /**
     * 视频编号
     */
    private Integer v_no;

    /**
     * 视频标题
     */
    private String v_title;

    /**
     * 播放量
     */
    private Integer v_amount_of_play;

    /**
     * 视频地址
     */
    private String v_url;

    /**
     * 用户
     */
    private Integer con_no;
    /**
     * 点赞数
     */
    private Integer v_likes;

    /**
     * 视频封面
     */
    private String v_pic;

    /**
     * 视频投币数
     */
    private Integer v_coins;

    /**
     * 视频被举报次数
     */
    private Integer v_reports;

    /**
     * 视频是否合法
     */
    private boolean v_legal;

    private String name;
}
