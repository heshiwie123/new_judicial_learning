package com.he.domin.enums;

import lombok.Getter;

@Getter
public enum LegalNatureType {
    LAW(1,"法律"),
    LOCAL_REGULATION(2,"地方法规"),
    LOCAL_GOVERNMENT_REGULATION(3,"地方政府规章"),
    LOCAL_GOVERNMENT_NORMATIVE(4,"地方规范性文件"),
    LOCAL_GOVERNMENT_SPELLCASTING(5,"地方施法文件"),
    ADMINSTRATIVE_REGULATION(6,"地方施法文件"),
    LOCAL_GOVERNMENT_CORK(7,"地方工作文件")
    ;
    private int code;
    private String name;

    LegalNatureType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
