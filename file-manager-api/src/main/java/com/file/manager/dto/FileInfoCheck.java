package com.file.manager.dto;

import java.util.List;
import java.util.Map;

public class FileInfoCheck<T> {

    private Long status; // 文件状态  1、文件已存在 0、文件正在上传 2、文件不存在

    private boolean shouldUpload; // 是否需要上传

    private T data;


    public FileInfoCheck() {
    }


    public FileInfoCheck(Long status, boolean shouldUpload, T data) {
        this.status = status;
        this.shouldUpload = shouldUpload;
        this.data = data;
    }

    public static <T> FileInfoCheck<T> fileInfo(Long status, boolean shouldUpload, T data) {
        return new FileInfoCheck<>(status, shouldUpload, data);
    }

    @Override
    public String toString() {
        return "FileInfoCheck{" +
                "status=" + status +
                ", shouldUpload=" + shouldUpload +
                ", data=" + data +
                '}';
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public boolean isShouldUpload() {
        return shouldUpload;
    }

    public void setShouldUpload(boolean shouldUpload) {
        this.shouldUpload = shouldUpload;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
