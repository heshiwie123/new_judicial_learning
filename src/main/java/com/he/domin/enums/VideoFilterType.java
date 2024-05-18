package com.he.domin.enums;

import lombok.Getter;

@Getter
public enum VideoFilterType {

    //综合排序（点击量，发布时间，弹幕量，收藏量）
    COMPOSITE_VIEW_MOST(1,"最多点击量"),
    COMPOSITE_PUBLISH_LATEST(2,"最新发布"),
    COMPOSITE_DANMU_MOST(3,"最多弹幕"),
    COMPOSITE_COLLECT_MOST(4,"最多收藏"),
    //付费类型排序
    PAYMENT_FREE(21,"免费"),
    PAYMENT_PAY(22,"需要支付"),

    //关键词筛选
    KEYWORD_FIRST(31,"合同风险"),
    KEYWORD_SECOND(32,"合同漏洞"),
    KEYWORD_THIRD(33,"合同常识"),
    KEYWORD_FOURTH(34,"合同案例"),
    KEYWORD_FIFTH(35,"合同法"),
    ;

    private final int code;
    private final String name;

    VideoFilterType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(int code) {
        for (VideoFilterType type : VideoFilterType.values()) {
            if (type.getCode() == code) {
                return type.getName();
            }
        }
        return null; // 或者抛出一个异常，如果你认为 code 无效或未找到
    }
}
