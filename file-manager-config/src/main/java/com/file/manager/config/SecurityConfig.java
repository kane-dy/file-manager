package com.file.manager.config;

import com.file.manager.handler.JwtFailureHandler;
import com.file.manager.handler.JwtSuccessHandler;
import com.file.manager.security.JsonLoginFilter;
import com.file.manager.security.JwtAuthenticationEntryPoint;
import com.file.manager.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtSuccessHandler jwtSuccessHandler;

    @Autowired
    private JwtFailureHandler jwtFailureHandler;
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfig(JwtSuccessHandler successHandler, JwtFailureHandler failureHandler) {
        this.jwtSuccessHandler = successHandler;
        this.jwtFailureHandler = failureHandler;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        // 这样你就可以在任何地方 @Autowired PasswordEncoder 了
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public JsonLoginFilter jsonLoginFilter(AuthenticationManager authenticationManager) {
        JsonLoginFilter filter = new JsonLoginFilter(authenticationManager);
        filter.setAuthenticationSuccessHandler(jwtSuccessHandler);
        filter.setAuthenticationFailureHandler(jwtFailureHandler);
        return filter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationConfiguration authConfig,
                                           AuthenticationManager authenticationManager) throws Exception {
        http
                // 1. 关闭 CSRF（跨站请求伪造）保护，否则 POST 请求会被拦截
                .csrf(csrf -> csrf.disable())
                //禁用session，因为 JWT 是无状态的
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                // 2. 配置请求授权
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll() // 注册登录接口放行
                        .anyRequest().authenticated() // 其他所有接口都需要认证
                )
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint)                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(jsonLoginFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)

                .httpBasic(Customizer.withDefaults());



        return http.build();
    }
}
