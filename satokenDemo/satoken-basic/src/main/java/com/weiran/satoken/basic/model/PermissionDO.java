package com.weiran.satoken.basic.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Weiran
 * @since 2021-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
public class PermissionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String permissionCode;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限解释
     */
    private String info;


}
