package com.file.manager.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.manager.dto.LoginRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

public class JsonLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();


    public JsonLoginFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/login", "POST"));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        // 1、判断是否为json
        if (!"application/json".equals(request.getContentType())) {
            throw new IllegalArgumentException("Content-Type must be application/json");
        }

        LoginRequest loginReq = objectMapper.readValue(request.getInputStream(), LoginRequest.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword());
        getAuthenticationManager().authenticate(token);
        return getAuthenticationManager().authenticate(token);


    }
}
