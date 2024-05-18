package com.he.domin.enums;

import lombok.Getter;

@Getter
public enum OptionType {
    OPTION_A(1,"A"),
    OPTION_B(2,"B"),
    OPTION_C(3,"C"),
    OPTION_D(4,"D"),
    OPTION_E(5,"E"),
    OPTION_F(6,"F"),
    OPTION_G(7,"G"),
    OPTION_CORRECT(100,"CORRECT"),
    OPTION_FALSE(-100,"FALSE")
    ;
    private int code;
    private String name;
    OptionType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
