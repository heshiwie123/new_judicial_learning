package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.AddUserRequestDto;
import com.he.domin.dto.UserRequestDto;
import com.he.domin.entity.mysql.User;

import java.util.Map;

public interface IUserService extends IService<User> {

    /**
     * 登录服务，请求体
     * @param userRequestDto 用户注册请求体
     * @return map包括用户信息和token
     */
    Map<String,Object> login(UserRequestDto userRequestDto);

    /**
     * 用户注册
     * 用户实体
     * @return 执行结果
     */
    Boolean addUser(AddUserRequestDto addUserRequestDto);
}
