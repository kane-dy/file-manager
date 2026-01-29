package com.file.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.file.manager.entity.RefreshToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RefreshTokenMapper  extends BaseMapper<RefreshToken> {
}
