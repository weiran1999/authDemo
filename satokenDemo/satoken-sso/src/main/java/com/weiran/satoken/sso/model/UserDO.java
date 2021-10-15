package com.weiran.satoken.sso.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户表

 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id，--主键、自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sataken登陆码
     */
    private String loginId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 明文密码
     */
    private String pw;

    /**
     * 所属角色id
     */
    private Integer roleId;


}
