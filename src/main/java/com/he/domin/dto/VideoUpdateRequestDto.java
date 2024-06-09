package com.he.domin.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class VideoUpdateRequestDto {

    private Integer videoId;

    private Integer sumLike;

    private Integer sumCollect;

    private Integer sumComment;

    private Integer sumShare;

    private Integer sumView;

    private Integer sumDanMu;
}
