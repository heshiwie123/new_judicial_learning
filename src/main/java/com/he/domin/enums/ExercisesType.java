package com.he.domin.enums;

import lombok.Getter;

@Getter
public enum ExercisesType {
    CHOICE(1, "选择题"),
    FILL_BLANK(2, "填空题"),
    TRUE_FALSE(3, "判断题"),
    SHORT_ANSWER(4, "解答题"),
    CALCULATION(5, "计算题"),
    ANALYSIS(6, "分析题"),
    SORT(7, "排序题"),
    FILL_CHART(8, "填图题"),
    COMPREHENSIVE(9, "综合题");
    private int code;
    private String name;

    ExercisesType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
