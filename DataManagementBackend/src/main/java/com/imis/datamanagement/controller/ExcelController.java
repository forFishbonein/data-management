package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.service.ExcelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Resource
    ExcelService excelService;


    @PostMapping("/export")
    public Result<String> sendMimeMail(@RequestBody List<List<String>> lists) {
        excelService.export(lists);
        return Result.success("导出成功");
    }
}
