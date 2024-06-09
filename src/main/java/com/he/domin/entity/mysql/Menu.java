package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("menu")
@Accessors(chain = true)
public class Menu {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 权限名字
     */
    @TableField(value = "name")
    private String name;
    /**
     *权限的父级权限
     */
    @TableField(value = "parent_id")
    private String parentId;
    /**
     *权限名称
     */
    @TableField(value = "perms")
    private String perms;
    /**
     *权限类型
     */
    @TableField(value = "menu_type")
    private String menuType;
    /**
     *权限对应的接口uri路径
     */
    @TableField(value = "path")
    private String path;
}
