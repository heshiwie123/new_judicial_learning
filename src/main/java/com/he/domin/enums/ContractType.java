package com.he.domin.enums;

import lombok.Getter;

//合同类型
@Getter
public enum ContractType {
    SALES_CONTRACT(1,"买卖合同"),
    ENERGY_SUPPLY_CONTRACT(2,"供给能源合同"),
    LOAN_CONTRACT(3,"借款合同"),
    GUARANTEE_CONTRACT(4,"担保合同"),
    LEASING_FINANCIAL_LEASING_CONTRACT(5,"租赁与融资租赁合同"),
    PROCESSING_CONTRACT(6,"加工承揽合同"),
    CONSTRUCTION_CONTRACT(7,"建设工程合同"),
    ;
    private int code;
    private String name;

    ContractType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
