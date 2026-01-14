package com.file.manager.dto;

import java.time.LocalDateTime;

public class FileDto {

    private Long id; // 逻辑表ID

    private String fileName; //显示的文件或文件夹名称

    private Long parentId; //父目录ID，根目录设为 0 parent_id

    private Integer isDir; //是否为目录 (1: 是, 0: 否)

    private String pathTrace; //路径追踪索引，例如 "0/5/12/" (用于快速深度搜索)

    // 物理信息 (来自 file_entities)
    private Long fileSize;

    private String fileHash;

    // 辅助字段
    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsDir() {
        return isDir;
    }

    public void setIsDir(Integer isDir) {
        this.isDir = isDir;
    }

    public String getPathTrace() {
        return pathTrace;
    }

    public void setPathTrace(String pathTrace) {
        this.pathTrace = pathTrace;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
