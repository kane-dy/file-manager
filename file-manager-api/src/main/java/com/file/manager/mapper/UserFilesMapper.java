package com.file.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.file.manager.entity.UserFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserFilesMapper extends BaseMapper<UserFiles> {

    /**
     * 批量更新子孙节点的路径前缀 (移动文件夹核心)
     * @param oldPrefix 原路径起点，如 "0/1/5/"
     * @param newPrefix 新路径起点，如 "0/2/10/5/"
     */
    @Update("UPDATE user_files SET path_trace = REPLACE(path_trace, #{oldPrefix}, #{newPrefix}) " +
            "WHERE path_trace LIKE #{oldPrefix} || '%'")
    int updateSubFolderPaths(@Param("oldPrefix") String oldPrefix,
                             @Param("newPrefix") String newPrefix);
}
