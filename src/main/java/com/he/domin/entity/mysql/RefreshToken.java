package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("refresh_token")
public class RefreshToken {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * refreshToken，对比这个字段才能允许刷新
     */
    @TableField(value = "token")
    private String token;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 存储用户信息，这是刷新accessToken的根据
     */
    private User userInfo;
}
