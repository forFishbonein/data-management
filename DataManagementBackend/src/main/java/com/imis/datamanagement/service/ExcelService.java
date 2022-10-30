package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/30
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */


import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.exception.GlobalException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public void export(HttpServletRequest req, HttpServletResponse resp, List<List<String>> lists) {

        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Disposition","attachment;filename=\"duty.xls\"");


        List<String> l0 = new ArrayList<>();
        List<String> l1 = new ArrayList<>();

        l0 = lists.get(0);
        l1 = lists.get(1);

        System.out.println(lists);
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("sheet01");
        //创建行（从0开始）
        Row row = sheet.createRow(0);
        //创建单元格(第一列)
        Cell cell = null;
        for (int item = 0; item < l0.size(); item += 1) {
            cell = row.createCell(item);
            cell.setCellValue(l0.get(item));
        }
        //创建行（从0开始）
        row = sheet.createRow(1);
        for (int item = 0; item < l1.size(); item += 1) {
            cell = row.createCell(item);
            cell.setCellValue(l1.get(item));
        }
        try {
            OutputStream outputStream = resp.getOutputStream();

            //FileOutputStream out = new FileOutputStream("E:\\s3d4.xls");
            wb.write(outputStream);
            //流的关闭
            //out.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);

        }
        //创建流并将wb输出



        return;
    }


}
