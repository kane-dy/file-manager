package com.file.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.file.manager.entity.FileChunk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileChunkMapper  extends BaseMapper<FileChunk> {
}
