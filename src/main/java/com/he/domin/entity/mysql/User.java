package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@TableName("user")
@Accessors(chain = true)
//SpringSecurity会将认证的用户存到UserDetails中
public class User implements Serializable, UserDetails {
    /**
     * 用户id
     * 这里一定要制定为type = IdType.AUTO，让mysql来自增，若不指定
     * sbjava会默认一个巨大的整形，而且可能出现负值
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 用户年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     * 用户性别
     */
    @TableField(value = "sex")
    private Boolean sex;
    /**
     * 用户签名
     */
    @TableField(value = "signature")
    private String signature;
    /**
     * 用户头像图片
     */
    @TableField(value = "profile_photo")
    private String profilePhoto;
    /**
     * 用户电话号码
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 用户状态
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 用户是否私密
     */
    @TableField(value = "is_secret")
    private Integer isSecret;

    /**
     * 角色信息
     */
    private Set<Identity> identitySet;
    /**
     * 角色信息
     */
    private Set<String> menuSet;

    /**
     * 获得用户的权限信息
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //权限告知SpringSecurity
        //lambda表达式将Set<String>=》collection<GrantedAuthority>
        if (menuSet != null && !menuSet.isEmpty()) {
            return menuSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        }
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    //    state为1时表明为正常用户
    @Override
    public boolean isAccountNonExpired() {
        return state == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return state == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return state == 1;
    }

    @Override
    public boolean isEnabled() {
        return state == 1;
    }
}
