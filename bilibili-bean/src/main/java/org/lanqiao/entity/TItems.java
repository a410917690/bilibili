package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.entity
 * @ClassName:TItems
 * @Description:
 * @Date 2021/2/17 18:38
 */
@Data
public class TItems implements Serializable {
    private Integer i_no;
    private String i_name;
    private Float per_price;
}
