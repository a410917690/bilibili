package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色(TRoles)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:46
 */
@Data
public class TRoles implements Serializable {
    private static final long serialVersionUID = 724910504659895704L;
    /**
     * 角色编号
     */
    private Integer role_no;
    /**
     * 角色名称
     */
    private String role_name;




}