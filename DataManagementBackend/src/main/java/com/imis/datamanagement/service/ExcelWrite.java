package com.imis.datamanagement.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelWrite {
    // 构建路径
    String PATH = "D:\\xunlei\\datas\\";
    @Test
    public void testWrite03() throws Exception {
        // 创建工作簿
        Workbook workbook = new HSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet("考核成绩表");
        // 创建第一行
        Row row1 = sheet.createRow(0);// 第一行
        List list1=new ArrayList<>();
        list1.add("1");
        list1.add("5");
        list1.add("哥们儿在这儿跟你说唱");
        // 创建单元格
        Cell cell1 = row1.createCell(0);// 第一行的第一列
        cell1.setCellValue("数学");
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(list1.toString());
        // 第二行
        Row row2 = sheet.createRow(1);// 第二行
        Cell cell21 = row2.createCell(0);// 第二行的第一列
        cell21.setCellValue("时间");
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        // 生成表,IO流,03版本使用xls后缀
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"考核成绩表03.xls");
        workbook.write(fileOutputStream);
        // 关闭流
        fileOutputStream.close();
        System.out.println("考核成绩表03输出完毕");
    }



    @Test
    public void testWrite07() throws Exception {
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet("考核成绩表");
        // 创建第一行
        Row row1 = sheet.createRow(0);// 第一行
        // 创建单元格
        Cell cell1 = row1.createCell(0);// 第一行的第一列
        cell1.setCellValue("语文");
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(100);
        // 第二行
        Row row2 = sheet.createRow(1);// 第一行
        Cell cell21 = row2.createCell(0);// 第一行的第一列
        cell21.setCellValue("时间");
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        // 生成表,IO流,07版本使用xlsx后缀
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"考核成绩表07.xlsx");
        workbook.write(fileOutputStream);
        // 关闭流
        fileOutputStream.close();
        System.out.println("考核成绩表07输出完毕");
    }
}
