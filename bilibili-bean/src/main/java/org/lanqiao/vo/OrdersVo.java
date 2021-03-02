package org.lanqiao.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:OrdersVo
 * @Description:
 * @Date 2021/2/18 12:42
 */
@Data
public class OrdersVo implements Serializable {
    private Long o_no;
    private Float money;
    private String i_name;
    private String retUrl;
}
