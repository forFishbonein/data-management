package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.service.ExcelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Resource
    ExcelService excelService;


    @PostMapping("/export")
    public Result<String> sendMimeMail(HttpServletRequest req, HttpServletResponse resp, @RequestBody List<List<String>> lists) {
        excelService.export(req, resp, lists);
        return Result.success("导出成功");
    }
}
