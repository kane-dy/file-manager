package com.file.manager.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class LocalCacheConfig {
    @Bean
    public Cache<String, Object> dictCache() {
        return Caffeine.newBuilder()
                // 设置初始容量
                .initialCapacity(200)
                // 设置最大缓存个数，超过时根据 LRU 淘汰
                .maximumSize(1000)
                // 设置写入后多久过期
                .expireAfterWrite(30, TimeUnit.MINUTES)
                // 开启记录统计（可选，用于监控命中率）
                .recordStats()
                .build();
    }
}
