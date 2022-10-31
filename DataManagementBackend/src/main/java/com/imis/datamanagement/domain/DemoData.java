package com.imis.datamanagement.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;

import  java.util.*;
import java.util.Date;


@Data
public class DemoData {

//    @ExcelProperty("标题")
    @ExcelIgnore
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    public Double doubleData;
    //忽略这个字段
    @ExcelIgnore
    private String ignore;
}
