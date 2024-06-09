package com.he.domin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
//浏览历史更新请求体
public class BrowseHistoryUpdateRequestDto {
    private Integer browseHistoryId;
    private Integer timeStamp;
    private LocalDateTime updateTime;
    private Boolean isLike;
    private Boolean isShare;
    private Boolean isCollect;
}
