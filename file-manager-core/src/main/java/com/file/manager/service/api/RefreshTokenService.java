package com.file.manager.service.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.file.manager.entity.RefreshToken;

public interface RefreshTokenService extends IService<RefreshToken> {
    boolean saveRefreshToken(String username, String token);
}
