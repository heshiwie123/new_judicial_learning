package com.he.domin.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UserRequestDto {
    protected String username;
    protected String password;
}
