package com.he.domin.dto;

import lombok.Data;
import lombok.Getter;

//视频请求体
@Data
public class VideoRequestDto {
    //这里对于基础条件直接使用int 防止出现空值
    //而枚举类型keyWordType使用Integer，可以对枚举有一定操作
    private Integer compositeFilter;

    private Boolean paymentType;

    private Integer keyWordType;

    private Integer pageNumber ;

    private Integer pageSize ;
}
