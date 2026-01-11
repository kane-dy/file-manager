package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Objects;

@TableName("users")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String username;

    private String path;

    @TableField(select = false, condition = "password_hash")
    private String passwordHash;

    private Long status;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("update_at")
    private LocalDateTime updataAt;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", path='" + path + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updataAt=" + updataAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(path, user.path) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(status, user.status) && Objects.equals(createdAt, user.createdAt) && Objects.equals(updataAt, user.updataAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, path, passwordHash, status, createdAt, updataAt);
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdataAt() {
        return updataAt;
    }

    public void setUpdataAt(LocalDateTime updataAt) {
        this.updataAt = updataAt;
    }
}
