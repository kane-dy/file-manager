package com.file.manager.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.manager.dto.AuthResponse;
import com.file.manager.utils.JwtSecurityJsonUtils;
import com.file.manager.utils.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtSuccessHandler  implements AuthenticationSuccessHandler {

    private JwtSecurityJsonUtils jwtSecurityJsonUtils;

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
        String token = jwtSecurityJsonUtils.generateToken(username);
        AuthResponse authResponse = new AuthResponse(token);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Result<AuthResponse> authResponseResult = Result.messageInfor(HttpServletResponse.SC_OK, "登录成功", authResponse);
        response.getWriter().write(new ObjectMapper().writeValueAsString(authResponseResult));

    }
}
