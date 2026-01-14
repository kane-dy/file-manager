package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Objects;
@TableName("file_entities")
public class FileEntities {
    
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("file_hash")
    private String fileHash;  //文件的SHA256值，唯一，用于秒传

    @TableField("file_size")
    private Long  fileSize; //文件大小（字节）

    @TableField("storage_path")
    private String  storagePath; // 文件在磁盘或云端的存储位置

    @TableField("created_id")
    private String    createdId;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("status")
    private Long status; // 0-上传中, 1-已完成

    public FileEntities(Long id, String fileHash, Long fileSize, String storagePath, String createdId, LocalDateTime createdAt, Long status) {
        this.id = id;
        this.fileHash = fileHash;
        this.fileSize = fileSize;
        this.storagePath = storagePath;
        this.createdId = createdId;
        this.createdAt = createdAt;
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileEntities{" +
                "id=" + id +
                ", fileHash='" + fileHash + '\'' +
                ", fileSize=" + fileSize +
                ", storagePath='" + storagePath + '\'' +
                ", createdId='" + createdId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
