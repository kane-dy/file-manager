//@PostMapping("/upload-chunk")
//@Transactional
//public String uploadChunk(
//        @RequestParam("chunk") MultipartFile chunk,
//        @RequestParam("index") Integer index,
//        @RequestParam("fileHash") String fileHash
//) throws IOException {
//    // 1. 保存到磁盘 temp 目录
//    Path chunkPath = Paths.get("D:/uploads/temp", fileHash, String.valueOf(index));
//    if (!Files.exists(chunkPath.getParent())) Files.createDirectories(chunkPath.getParent());
//    Files.copy(chunk.getInputStream(), chunkPath, StandardCopyOption.REPLACE_EXISTING);
//
//    // 2. 写入数据库记录（防止扫描磁盘带来的 IO 压力）
//    chunkService.saveChunkRecord(fileHash, index);
//
//    return "ok";
//}
//
//
//@PostMapping("/merge")
//public String merge(@RequestBody Map<String, String> params) throws IOException {
//    String fileHash = params.get("fileHash");
//    String fileName = params.get("fileName");
//
//    // 1. 执行物理合并 (使用 FileChannel.transferTo 零拷贝)
//    String finalRelativePath = fileHash + "/" + fileName;
//    Path finalPath = Paths.get("D:/uploads/final", finalRelativePath);
//    performPhysicalMerge(fileHash, finalPath);
//
//    // 2. 更新数据库状态
//    fileInfoService.updateStatusToComplete(fileHash, finalPath.toString());
//
//    // 3. 清理临时记录和文件
//    chunkService.deleteRecordsByHash(fileHash);
//
//    return "merge success";
//}