package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("user_files")
public class UserFiles {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId; //所属用户ID user_id
    @TableField("entity_id")
    private Long entityId; //指向物理文件ID（若是文件夹则此项为 NULL） entity_id
    // 目录层级核心字段

    @TableField("parent_id")
    private Long parentId ; // -- 父目录ID，根目录设为 0 parent_id

    @TableField("file_name")
    private String  fileName; //-- 显示的文件或文件夹名称

    @TableField("is_dir")
    private Long isDir; //是否为目录 (1: 是, 0: 否)

    @TableField("path_trace")
    private String pathTrace; //路径追踪索引，例如 "0/5/12/" (用于快速深度搜索)

    @TableField("is_deleted")
    private Long isDeleted; //逻辑删除标识 (1: 已删除)

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("update_at")
    private LocalDateTime updataAt;

    public UserFiles(Long id, Long userId, Long entityId, Long parentId, String fileName, Long isDir, String pathTrace, Long isDeleted, LocalDateTime createdAt, LocalDateTime updataAt) {
        this.id = id;
        this.userId = userId;
        this.entityId = entityId;
        this.parentId = parentId;
        this.fileName = fileName;
        this.isDir = isDir;
        this.pathTrace = pathTrace;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updataAt = updataAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getIsDir() {
        return isDir;
    }

    public void setIsDir(Long isDir) {
        this.isDir = isDir;
    }

    public String getPathTrace() {
        return pathTrace;
    }

    public void setPathTrace(String pathTrace) {
        this.pathTrace = pathTrace;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
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
