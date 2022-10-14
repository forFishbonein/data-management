package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.common.vo.PicUploadResult;
import com.imis.datamanagement.service.PicUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping("/pic/upload")
@Controller
public class PicUploadController {

    @Resource
    private PicUploadService picUploadService;

    @PostMapping
    @ResponseBody
    public Result<PicUploadResult> upload(@RequestParam("file") MultipartFile multipartFile) {
        return Result.success(picUploadService.upload(multipartFile));
    }
}
