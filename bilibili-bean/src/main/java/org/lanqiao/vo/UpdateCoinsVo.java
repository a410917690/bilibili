package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCoinsVo implements Serializable {
    private static final long serialVersionUID = 792526065938981399L;

    private Integer v_no;

    private Integer v_coins;

    private Integer con_no;

    private Integer coins;

}
