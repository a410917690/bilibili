package org.lanqiao.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:ConsumerCodeVo
 * @Description:
 * @Date 2021/2/8 10:20
 */
@Data
@Setter
@Getter
public class ConsumerCodeVo implements Serializable {
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 验证码
     */
    private String code;
}
