package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("user")
@Accessors(chain = true)
public class User{
    /**
     * 用户id
     */
    @TableId(value = "id")
    private Integer id;
    /**
     *用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     *用户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     *用户年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     *用户性别
     */
    @TableField(value = "sex")
    private Boolean sex;
    /**
     *用户签名
     */
    @TableField(value = "signature")
    private String signature;
    /**
     *用户头像图片
     */
    @TableField(value = "profile_photo")
    private String profilePhoto;
    /**
     *用户电话号码
     */
    @TableField(value = "phone")
    private String phone;
    /**
     *用户邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     *用户状态
     */
    @TableField(value = "state")
    private Integer state;
    /**
     *用户是否私密
     */
    @TableField(value = "is_secret")
    private Integer idSecret;
}
