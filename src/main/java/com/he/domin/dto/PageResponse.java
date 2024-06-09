package com.he.domin.dto;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
public class PageResponse<T> {
    private List<T> records;
    private Long total;
    private Integer size;
    private Integer current;
    private Integer pages;
}
