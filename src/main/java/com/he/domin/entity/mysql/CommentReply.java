package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@TableName("video_comment_reply")
@Accessors(chain = true)
public class CommentReply {
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
     * 回复的评论id
     */
    @TableField(value = "comment_id")
    private Integer commentId;
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
     * 评论回复的人的id
     */
    @TableField(value = "reply_user_id")
    private Integer replyUserId;
    /**
     * 评论回复的人的用户名
     */
    @TableField(value = "reply_user_name")
    private String replyUserName;
    /**
     * 总点赞量
     */
    @TableField(value = "sum_like")
    private Integer sumLike;
    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;
}
