package com.file.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.file.manager.dto.FileInfoCheck;
import com.file.manager.entity.FileChunk;
import com.file.manager.entity.FileEntities;
import com.file.manager.mapper.FileChunkMapper;
import com.file.manager.mapper.FileEntitiesMapper;
import com.file.manager.mapper.FileMapper;
import com.file.manager.service.api.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FileInfoServiceImlp extends ServiceImpl<FileEntitiesMapper, FileEntities> implements FileInfoService {

    @Autowired
    private FileEntitiesMapper fileEntitiesMapper;


    @Autowired
    private FileChunkMapper fileChunkMapper;
    /**
     *
     * @param
     * @return
     */
    @Override
    public FileInfoCheck getFileEntitiesHash(String  fileHash){
        FileEntities fileEntities = fileEntitiesMapper.selectOne(new LambdaQueryWrapper<FileEntities>().eq(FileEntities::getFileHash, fileHash));
        Optional<FileEntities> fileinfo = Optional.ofNullable(fileEntities);
        if(fileinfo.isPresent() && fileEntities.getStatus() == 1){
            return FileInfoCheck.fileInfo(fileEntities.getStatus(), false, fileEntities.getStoragePath());
        } else if (fileinfo.isPresent() && fileEntities.getStatus() == 0) {
            // 方案二（更可靠）：查询逻辑表
            List<FileChunk> fileChunks = fileChunkMapper.selectList(new LambdaQueryWrapper<FileChunk>().eq(FileChunk::getFileHash, fileHash));
            List<Long> chunkIndexes = fileChunks.stream().map(FileChunk::getChunkIndex).collect(Collectors.toList());
            return FileInfoCheck.fileInfo(fileEntities.getStatus(), true,chunkIndexes);
        }else {
            return FileInfoCheck.fileInfo( 2L, true, null);
        }

    }
}
