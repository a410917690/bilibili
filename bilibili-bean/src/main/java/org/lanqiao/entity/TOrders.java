package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.entity
 * @ClassName:TOrder
 * @Description:
 * @Date 2021/2/17 18:43
 */
@Data
public class TOrders implements Serializable {
    private Long o_no;
//    private String o_no;
    private Integer con_no;
    private Float money;
    private Timestamp o_time;
    private Boolean o_status;
    private Integer i_no;
    private String i_name;
}
