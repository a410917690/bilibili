package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class THistoryVo implements Serializable {
    private static final long serialVersionUID = 792526065938981392L;

    private Integer his_no;

    private Integer v_no;

    private String v_title;

    private Integer con_no;

    private String v_pic;

    private Date watch_date;
}

