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
}
