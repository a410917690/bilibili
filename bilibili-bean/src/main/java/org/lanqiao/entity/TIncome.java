package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.entity
 * @ClassName:TIncoming
 * @Description:
 * @Date 2021/2/24 16:30
 */
@Data
public class TIncome implements Serializable {
    Integer in_no;
    Float money;
    Timestamp date;
}
