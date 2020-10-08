package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(ConsumersVo)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:44
 */
@Data
public class TConsumers implements Serializable {
    private static final long serialVersionUID = 792526065938981399L;
    /**
     * 用户编号
     */
    private Integer con_no;
    /**
     * 角色编号
     */
    private Integer role_no;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 硬币
     */
    private Integer coins;
    /**
     * 注册日期
     */
    private Date reg_date;
    /**
     * 成为会员后的会员到期时间
     */
    private Date member_deadline;
    /**
     * 用户是否合法
     */
    private Integer con_is_legal;

    private String tel_num;

}