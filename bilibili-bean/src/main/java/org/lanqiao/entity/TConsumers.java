package org.lanqiao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * 用户(ConsumersVo)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:44
 */
@Data
@Setter
@Getter
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
    /**
     * 电话号码
     */
    private String tel_num;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 头像
     */
    private byte[] pic;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 被举报次数
     */
    private Integer report_num;
}