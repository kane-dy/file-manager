package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 存储文件信息
 */
@TableName("files")
public class Files {
    // 文件ID
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    // 用户名称
    @TableField(condition = "username")
    private String username;

    // 文件路径
    @TableField( condition = "file_path")
    private String filePath;

    // 文件名
    @TableField(condition = "file_name")
    private String file_name;

    // 文件状态
    /**
     * 0 是文件夹
     * 1 是文件
     */
    @TableField(condition = "file_status")
    private Long fileStatus;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("update_at")
    private LocalDateTime updataAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Files files = (Files) o;
        return Objects.equals(id, files.id) && Objects.equals(username, files.username) && Objects.equals(filePath, files.filePath) && Objects.equals(file_name, files.file_name) && Objects.equals(fileStatus, files.fileStatus) && Objects.equals(createdAt, files.createdAt) && Objects.equals(updataAt, files.updataAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, filePath, file_name, fileStatus, createdAt, updataAt);
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", filePath='" + filePath + '\'' +
                ", file_name='" + file_name + '\'' +
                ", fileStatus=" + fileStatus +
                ", createdAt=" + createdAt +
                ", updataAt=" + updataAt +
                '}';
    }

    public Files(Long id, String username, String filePath, String file_name, Long fileStatus, LocalDateTime createdAt, LocalDateTime updataAt) {
        this.id = id;
        this.username = username;
        this.filePath = filePath;
        this.file_name = file_name;
        this.fileStatus = fileStatus;
        this.createdAt = createdAt;
        this.updataAt = updataAt;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Long getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Long fileStatus) {
        this.fileStatus = fileStatus;
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
