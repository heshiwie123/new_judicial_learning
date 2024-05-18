package com.he.domin.enums;

import lombok.Getter;

@Getter
//制定机关
public enum FormulationOrganType {

    SUPREME_COURT(1, "最高法院"),
    LOCAL_COURT(2, "地方法院"),
    HIGH_COURT(3, "高级法院"),
    ADMINISTRATIVE_COURT(4, "行政法院"),
    JUDICIAL_COMMITTEE(5, "司法委员会");
    private int code;
    private String name;

    FormulationOrganType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
