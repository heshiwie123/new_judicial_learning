package com.he.domin.dto;

import lombok.Data;

@Data
public class AddCommentDto {
    private Integer videoId;
    private Integer userId;
    private String content;
}
