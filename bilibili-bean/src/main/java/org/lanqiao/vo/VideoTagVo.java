package org.lanqiao.vo;

import lombok.Data;

@Data
public class VideoTagVo {
    private static final long serialVersionUID = 792526065938981394L;

    /**
     *主键
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

    /**
     * 标签名称
     */
    private String t_name;


}
