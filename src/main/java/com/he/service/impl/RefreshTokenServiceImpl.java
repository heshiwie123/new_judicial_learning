package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.entity.mysql.RefreshToken;
import com.he.mapper.RefreshTokenMapper;
import com.he.service.IRefreshTokenService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefreshTokenServiceImpl extends ServiceImpl<RefreshTokenMapper, RefreshToken> implements IRefreshTokenService {
    @Resource
    private RefreshTokenMapper refreshTokenMapper;
    @Override
    public RefreshToken getRefreshTokenByToken(String token) {
        log.info("RefreshTokenServiceImpl====>getByRefreshTokenToken====>{}",token);
        LambdaQueryWrapper<RefreshToken> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RefreshToken::getToken,token);
        return refreshTokenMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public RefreshToken getRefreshTokenByUserId(Long userId) {
        log.info("RefreshTokenServiceImpl====>getByRefreshTokenUserId====>{}",userId);
        LambdaQueryWrapper<RefreshToken> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RefreshToken::getUserId,userId);
        return refreshTokenMapper.selectOne(lambdaQueryWrapper);
    }
}
