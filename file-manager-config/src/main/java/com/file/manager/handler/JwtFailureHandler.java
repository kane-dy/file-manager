package com.file.manager.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.manager.utils.Result;
import com.file.manager.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import java.util.Map;

@Component
public class JwtFailureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        objectMapper.writeValue(response.getWriter(),
//                Map.of("error", "Authentication failed", "message", exception.getMessage()));
        response.getWriter().write(new ObjectMapper().writeValueAsString(Result.error(ResultCode.UNAUTHORIZED)));
    }
}
