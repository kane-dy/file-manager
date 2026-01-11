package com.file.manager.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.manager.utils.Result;
import com.file.manager.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // 设置响应头
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");

        // 使用 Jackson 序列化成字符串写入
        response.getWriter().write(new ObjectMapper().writeValueAsString(Result.error(ResultCode.TOKEN_UNAUTHORIZED)));

    }
}
