package com.he.service;

import com.he.domin.entity.mysql.RefreshToken;

public interface IRefreshTokenService{
    public RefreshToken getRefreshTokenByToken(String token);
    public RefreshToken getRefreshTokenByUserId(Long userId);

}
