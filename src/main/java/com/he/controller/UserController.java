package com.he.controller;

import com.he.domin.dto.AddUserRequestDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.dto.UserRequestDto;
import com.he.domin.entity.mysql.RefreshToken;
import com.he.domin.entity.mysql.User;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IRefreshTokenService;
import com.he.service.IUserService;
import com.he.util.Constant;
import com.he.util.JwtUtils;
import com.he.util.exception.TokenRefreshException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "登录注册接口")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IRefreshTokenService refreshTokenService;
    @PostMapping("login")
    @Operation(summary = "login", description = "登录，登录完成会返回用户账号信息和token此后的任何请求都需要带上token")
    public ResponseResult login(@RequestBody UserRequestDto userRequestDto){
        Map<String, Object> resulpMap = userService.login(userRequestDto);
        if(resulpMap == null||resulpMap.get("access_token")==null){

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
    @PostMapping("/refreshToken")
    @Operation(summary = "refreshToken", description = "刷新token接口，需传入refreshToke")
    public ResponseResult refreshToken(HttpServletRequest request){
        String refreshToken = JwtUtils.getCookieValueByName(request,"jwt-refresh");

        if ((refreshToken != null) && (refreshToken.length() > 0)) {
            RefreshToken refreshTokenInfo = refreshTokenService.getRefreshTokenByToken(refreshToken);
            //获取对应用户信息
            User user = refreshTokenInfo.getUserInfo();
            if(refreshTokenInfo.getUserInfo() == null)return ResponseResult.errorResult(403,"refresh 对应用户信息为空！！！");
            //根据用户信息生成token
            Map<String, Object> tokenmap = new HashMap<>();
            tokenmap.put("用户Id", user.getId());
            tokenmap.put("用户Name", user.getUsername());
            tokenmap.put("用户身份", user.getIdentitySet());
            tokenmap.put("用户权限", user.getMenuSet());
            tokenmap.put("用户状态", user.getState());

            String accessToken = JwtUtils.createToken(tokenmap);

            return new ResponseResult(200,accessToken,"刷新token 成功！！");
        }

        return ResponseResult.errorResult(403,"refresh token 为空！！");
    }

}
