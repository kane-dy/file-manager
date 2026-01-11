//package com.file.manager.controller;
//
//import com.file.manager.entity.Files;
//import com.file.manager.service.api.FileService;
//import com.file.manager.utils.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/file")
//public class FileController {
//    @Autowired
//    private FileService fileService;
//
//    @GetMapping("/info")
//    public Result<List<Files>> getInfo(String filepath) {
//        List<Files> filesList = fileService.queryFile(filepath);
//        return Result.success(filesList);
//    }
//    @PostMapping("/save")
//    public Result<Boolean> saveFiles(@RequestBody Files files){
//        boolean b = fileService.saveOrUpdate(files);
//        return Result.success(b);
//    }
//    @PostMapping("/update")
//    public Result<Boolean> updateFiles (@RequestBody Files files){
//        boolean b = fileService.updateFile(files);
//        return Result.success(b);
//    }
//}
