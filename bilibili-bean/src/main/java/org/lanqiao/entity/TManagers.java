package org.lanqiao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员(TManagers)实体类
 *
 * @author makejava
 * @since 2020-10-07 11:12:45
 */
@Data
public class TManagers implements Serializable {
    private static final long serialVersionUID = -62500100624432066L;
    /**
     * 管理员编号
     */
    private Integer m_no;
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




}