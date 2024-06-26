package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;


import java.time.LocalDateTime;


@Data
@TableName("video_comment")
@Accessors(chain = true)
public class Comment {
    /**
     * 评论id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户头像
     */
    @TableField(value = "user_profile_photo")
    private String profilePhoto;
    /**
     * 视频id
     */
    @TableField(value = "video_id")
    private Integer videoId;
    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;
    /**
     * 评论发布时间
     */
    @TableField(value = "created_time")
    private LocalDateTime createdTime;
    /**
     * 总点赞量
     */
    @TableField(value = "sum_like")
    private Integer sumLike;
    /**
     * 总回复数
     */
    @TableField(value = "sum_reply")
    private Integer sumReply;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;
}
