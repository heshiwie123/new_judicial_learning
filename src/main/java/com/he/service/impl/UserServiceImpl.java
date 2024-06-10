package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.AddUserRequestDto;
import com.he.domin.dto.UserRequestDto;
import com.he.domin.entity.mysql.RefreshToken;
import com.he.domin.entity.mysql.User;
import com.he.mapper.IdentityMapper;
import com.he.mapper.RefreshTokenMapper;
import com.he.mapper.UserMapper;
import com.he.service.IUserService;
import com.he.util.Constant;
import com.he.util.JwtUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private IdentityMapper identityMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RefreshTokenMapper refreshTokenMapper;
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, Object> login(UserRequestDto userRequestDto) {
        //传入用户名，密码,这里针对这个用户信息记录了认证状态，目前：未认证
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword());

        //实现登录逻辑,会去调用在UserDetails里定义的loadUserByUsername
        //authenticate就是UserDetails
        Authentication authenticate = null;
        try {
            //尝试认证，配置了认证方法，会自动调用
            authenticate = authenticationManager.authenticate(authentication);
        } catch (RuntimeException e) {
            e.printStackTrace();
            log.info("用户名或者密码错误!");
            return null;
        }
        //获取返回的用户
        User user = (User) authenticate.getPrincipal();
        log.info("登录后的用户=======》{}", user);
        if (user == null) {
            return null;
        }

        //生成refreshToken
        Map<String, Object> refreshTokenmap = new HashMap<>();
        refreshTokenmap.put("用户Id",user.getId());

        //根据用户信息生成accessToken
        Map<String, Object> tokenmap = new HashMap<>();
        tokenmap.put("用户Id", user.getId());
        tokenmap.put("用户Name", user.getUsername());
        tokenmap.put("用户身份", user.getIdentitySet());
        tokenmap.put("用户权限", user.getMenuSet());
        tokenmap.put("用户状态", user.getState());

        //存储用户信息的map
        Map<String, Object> userMap = new HashMap<>();
        log.info("用户map==============================={}", tokenmap);
        //获取并存储用户个人信息
        userMap.put("userInfo", user);
        //存储token
        userMap.put("access_token", JwtUtils.createToken(tokenmap));
        String refreshToken = JwtUtils.createToken(refreshTokenmap);
        userMap.put("refresh_token", refreshToken);

        //同时需要增加一条RefreshToken信息
        RefreshToken refreshTokenInfo = new RefreshToken();
        refreshTokenInfo.setToken(refreshToken);

        refreshTokenInfo.setUserId(user.getId());
        refreshTokenMapper.insert(refreshTokenInfo);
        refreshTokenInfo.setUserInfo(user);
        return userMap;
    }

    @Override
    public Boolean addUser(AddUserRequestDto addUserRequestDto) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, addUserRequestDto.getUsername());
        if (userMapper.exists(queryWrapper)) {
            return Boolean.FALSE;
        }
        User user = new User();
        user.setUsername(addUserRequestDto.getUsername());
        //加密
        String encoderPassword = passwordEncoder.encode(addUserRequestDto.getPassword());
        user.setPassword(encoderPassword);
        //
        user.setAge(addUserRequestDto.getAge());
        user.setSex(addUserRequestDto.getSex());
        user.setSignature(addUserRequestDto.getSignature());
        user.setProfilePhoto(addUserRequestDto.getProfilePhoto());
        user.setPhone(addUserRequestDto.getPhone());
        user.setEmail(addUserRequestDto.getEmail());
        //用户默认身份设置
        log.info("用户默认身份initIdentity:==========================>{}", Constant.initIdentity);
        Integer defaultIdentityId = identityMapper.selectIdentityIdByName(Constant.initIdentity);

        //存入
        userMapper.insert(user);
        return userMapper.addUserIdentity(user.getId(), defaultIdentityId);
    }
}
