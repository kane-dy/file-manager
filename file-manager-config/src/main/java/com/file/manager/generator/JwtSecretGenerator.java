package com.file.manager.generator;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretGenerator {
    public static void main(String[] args) {
        // 1. 创建 32 字节 (256位) 的随机字节数组
        byte[] randomBytes = new byte[32];
        new SecureRandom().nextBytes(randomBytes);

        // 2. 转换为 Base64 编码的字符串
        String secret = Base64.getEncoder().encodeToString(randomBytes);

        System.out.println("生成的 JWT Secret (256-bit):");
        System.out.println(secret);
    }
}
