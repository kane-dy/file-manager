package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("refresh_token")
public class RefreshToken {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    private String username;

    @TableField("token")
    private String token;

    @TableField("expiry_date")
    private LocalDateTime expiryDate;


    @Override
    public String toString() {
        return "RefreshToken{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public RefreshToken() {
    }

    public RefreshToken(Long id, String username, String token, LocalDateTime expiryDate) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
