package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TCommentVo implements Serializable {
    private static final long serialVersionUID = 792526065938981152L;

    private Integer v_no;

    private Integer con_no;

    private Integer com_no;

    private Integer com_com_no;

    private String com_com;
}
