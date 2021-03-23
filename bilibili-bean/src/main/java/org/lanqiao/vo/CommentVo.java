package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:CommentVo
 * @Description:
 * @Date 2021/3/14 19:39
 */
@Data
public class CommentVo implements Serializable {

    private String name;
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


    private String com_time;

}
