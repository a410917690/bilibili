package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 观看历史(THistory)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class THistory implements Serializable {
    private static final long serialVersionUID = 775778623566381283L;
    /**
     * 历史记录编号
     */
    private Integer his_no;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 视频编号
     */
    private Integer v_no;
    /**
     * 观看时间
     */
    private Date watch_date;




}