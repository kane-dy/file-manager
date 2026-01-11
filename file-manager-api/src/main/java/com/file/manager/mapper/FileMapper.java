package com.file.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.file.manager.entity.Files;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper extends BaseMapper<Files> {
}
