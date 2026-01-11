package com.file.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.file.manager.entity.FileEntities;
import com.file.manager.entity.Files;
import com.file.manager.mapper.FileEntitiesMapper;
import com.file.manager.mapper.FileMapper;
import com.file.manager.service.api.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements FileService {
    @Autowired
    private FileEntitiesMapper fileEntitiesMapper;

    /**
     * 上传/秒传逻辑
     */
    @Transactional
    public boolean quickSave(Long userId, Long parentId, String fileName, String hash) {
        FileEntities fileEntities = fileEntitiesMapper.selectOne(new LambdaQueryWrapper<FileEntities>().eq(FileEntities::getFileHash, hash));

        return true;

    }
}
