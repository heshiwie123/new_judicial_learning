package com.he.domin.dto;

import lombok.Data;

@Data
public class AddCommentReplyDto {
    private Integer commentId;
    private Integer replyUserId;
    private Integer userId;
    private String content;
}
