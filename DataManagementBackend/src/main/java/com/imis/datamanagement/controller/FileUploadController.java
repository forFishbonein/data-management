package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.PicUploadResult;
import com.imis.datamanagement.domain.template.AbstractTemplate;
import com.imis.datamanagement.service.FileUploadService;
import com.imis.datamanagement.service.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileUploadController {

    @Autowired
    MongoDBService mongoDBService;

    @PutMapping
    public Result<String> insert(@RequestBody AbstractTemplate abstractTemplate) {
        mongoDBService.insertTemplate(abstractTemplate);
        return Result.success("新增成功");
    }

    @PostMapping
    public Result<String> update(@RequestBody AbstractTemplate abstractTemplate) {
        mongoDBService.updateTemplate(abstractTemplate);
        return Result.success("更新成功");
    }

    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ResponseBody
    public Result<PicUploadResult> upload(@RequestParam("file") MultipartFile multipartFile) {
        return Result.success(fileUploadService.upload(multipartFile));
    }
}
