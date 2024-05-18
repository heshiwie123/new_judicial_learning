package com.he.domin.dto;

import lombok.Data;

@Data
public class UpdateDanmuDto {
    private Integer danmuId;
    private String color;
    private Integer sumLike;
    private Integer isHot;
    private Integer isDeleted;
}
