package com.he.domin.dto;

import lombok.Data;

@Data
public class AddUserRequestDto {
    private String username;
    private String password;
    private Integer age;
    private Boolean sex;
    private String signature;
    private String profilePhoto;
    private String phone;
    private String email;
}
