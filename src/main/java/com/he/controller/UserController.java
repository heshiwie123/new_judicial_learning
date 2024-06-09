package com.he.controller;

import com.he.domin.dto.AddUserRequestDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.dto.UserRequestDto;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IUserService;
import com.he.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "登录注册接口")
public class UserController {

    @Resource
    private IUserService userService;
    @PostMapping("login")
    @Operation(summary = "login", description = "登录，登录完成会返回用户账号信息和token此后的任何请求都需要带上token")
    public ResponseResult login(@RequestBody UserRequestDto userRequestDto){
        Map<String, Object> resulpMap = userService.login(userRequestDto);
        if(resulpMap == null||resulpMap.get("token")==null){

            return ResponseResult.errorResult(500,"用户名或密码错误");
        }else {
            return new ResponseResult(200,"登录成功",resulpMap);
        }
    }

    @PutMapping("/register")
    @Operation(summary = "register", description = "注册，注册同样也是不需要token，需要传入用户注册信息")
    public ResponseResult register(@RequestBody AddUserRequestDto addUserRequestDto){
        Boolean result = userService.addUser(addUserRequestDto);
        if (result) return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode(), Constant.SUCCESS);
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"注册失败，或用户名已经存在");
    }
}
