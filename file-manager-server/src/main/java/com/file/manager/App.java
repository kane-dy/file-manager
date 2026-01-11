package com.file.manager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
public class App {
    public static void main(String[] args) {
        // 启动 Spring 应用上下文
        SpringApplication.run(App.class, args);
    }
}
