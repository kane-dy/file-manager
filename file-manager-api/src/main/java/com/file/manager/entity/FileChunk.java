package com.file.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("file_chunk")
public class FileChunk {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("file_hash")
    private String fileHash; //关联主表的hash

    @TableField("chunk_index")
    private Long chunkIndex;  // -- 切片索引

    @TableField("create_time")
    private LocalDateTime createTime;

    public FileChunk(Long id, String fileHash, Long chunkIndex, LocalDateTime createTime) {
        this.id = id;
        this.fileHash = fileHash;
        this.chunkIndex = chunkIndex;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FileChunk{" +
                "id=" + id +
                ", fileHash='" + fileHash + '\'' +
                ", chunkIndex='" + chunkIndex + '\'' +
                ", createTime=" + createTime +
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

    public Long getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(Long chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
