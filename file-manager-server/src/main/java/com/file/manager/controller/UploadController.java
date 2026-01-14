package com.file.manager.controller;

import com.file.manager.dto.FileInfoCheck;
import com.file.manager.service.api.FileInfoService;
import com.file.manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

import static com.file.manager.utils.Result.success;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private FileInfoService fileInfoService;

    @PostMapping("/check")
    public Result<FileInfoCheck> check(@RequestBody Map<String,String> params){
        String fileHash = params.get("fileHash");
        FileInfoCheck fileInfoCheck = fileInfoService.getFileEntitiesHash(fileHash);
        return Result.success(fileInfoCheck);
    }
}
