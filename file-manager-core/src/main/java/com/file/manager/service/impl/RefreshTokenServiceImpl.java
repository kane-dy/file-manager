package com.file.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.file.manager.entity.RefreshToken;
import com.file.manager.mapper.RefreshTokenMapper;
import com.file.manager.service.api.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class RefreshTokenServiceImpl extends ServiceImpl<RefreshTokenMapper, RefreshToken> implements RefreshTokenService {

    @Autowired
    private RefreshTokenMapper refreshTokenMapper;
    @Override
    public boolean saveRefreshToken(String username, String token) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUsername(username);
        refreshToken.setToken(token);
        refreshToken.setExpiryDate(LocalDateTime.now().plusDays(1));
        refreshTokenMapper.delete(new LambdaQueryWrapper<RefreshToken>()
                .eq(RefreshToken::getUsername, username)); // SQL:WHERE USERNAME = ?
        int row = refreshTokenMapper.insert(refreshToken);
        return row > 0;
    }
}
