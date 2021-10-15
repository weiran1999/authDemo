package com.weiran.satoken.sso.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class RoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id，--主键、自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称, 唯一约束
     */
    private String name;

    /**
     * 角色详细描述
     */
    private String info;


}
