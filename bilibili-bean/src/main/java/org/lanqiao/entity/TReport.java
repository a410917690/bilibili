package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TReport implements Serializable {
    private static final long serialVersionUID = -22747175769004478L;

    private Integer re_no;

    private Integer con_no;

    private Integer re_con_no;

    private Integer v_no;

    private Integer room_no;

    private String reason;
}
