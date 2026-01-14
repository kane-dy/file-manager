package com.file.manager.service.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.file.manager.dto.FileInfoCheck;
import com.file.manager.entity.FileEntities;

import java.util.Map;


public interface FileInfoService extends IService<FileEntities> {

    FileInfoCheck getFileEntitiesHash(String fileHash);
}
