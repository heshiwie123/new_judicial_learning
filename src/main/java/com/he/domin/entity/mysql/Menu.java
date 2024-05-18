package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("menu")
@Accessors(chain = true)
public class Menu {
    @TableId(value = "id")
    private Integer id;
    /**
     * 权限名字
     */
    private String name;
    /**
     *权限的父级权限
     */
    private String parentId;
    /**
     *权限名称
     */
    private String perms;
    /**
     *权限类型
     */
    private String menuType;
    /**
     *权限对应的接口uri路径
     */
    private String path;
}
