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

    final MongoDBService mongoDBService;

    public FileUploadController(MongoDBService mongoDBService) {
        this.mongoDBService = mongoDBService;
    }

    @PostMapping("/detail")
    @ResponseBody
    public Result<AbstractTemplate> getOneFile(@RequestBody AbstractTemplate abstractTemplate) {
        return Result.success(mongoDBService.getOneFile(abstractTemplate));
    }

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

    @DeleteMapping
    public Result<String> delete(@RequestBody AbstractTemplate abstractTemplate) {
        mongoDBService.deleteTemplate(abstractTemplate);
        return Result.success("删除成功");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result<Object> getById(@PathVariable("id") Long id) {
        return Result.success(mongoDBService.getById(id));
    }

    @GetMapping
    @ResponseBody
    public Result<Object> getAll() {
        return Result.success(mongoDBService.getAll());
    }

    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ResponseBody
    public Result<PicUploadResult> upload(@RequestParam("file") MultipartFile multipartFile) {
        return Result.success(fileUploadService.upload(multipartFile));
    }


}
