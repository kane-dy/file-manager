package com.file.manager.handler;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.manager.dto.AuthResponse;
import com.file.manager.entity.RefreshToken;
import com.file.manager.mapper.RefreshTokenMapper;
import com.file.manager.service.api.RefreshTokenService;
import com.file.manager.utils.JwtSecurityJsonUtils;
import com.file.manager.utils.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
import java.io.IOException;


@Component
public class JwtSuccessHandler  implements AuthenticationSuccessHandler {

    private JwtSecurityJsonUtils jwtSecurityJsonUtils;

    @Autowired
    private RefreshTokenService refreshTokenService;

    private final ObjectMapper objectMapper;

    public JwtSuccessHandler(JwtSecurityJsonUtils jwtUtil, ObjectMapper objectMapper) {
        this.jwtSecurityJsonUtils = jwtUtil;
        this.objectMapper = objectMapper;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        String username = authentication.getName();
        String accesstoken = jwtSecurityJsonUtils.generateToken(username);

        String refreshTokenStr = UUID.randomUUID().toString(); // 或者使用长效JWT
        AuthResponse authResponse = new AuthResponse(accesstoken,refreshTokenStr);

        Boolean b=refreshTokenService.saveRefreshToken(username, refreshTokenStr);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Result<AuthResponse> authResponseResult = Result.messageInfor(HttpServletResponse.SC_OK, "登录成功", authResponse);
        response.getWriter().write(new ObjectMapper().writeValueAsString(authResponseResult));

    }


}
