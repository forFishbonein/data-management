package com.imis.datamanagement.domain.template;
/*
 *
 * @Time : 2022/10/13
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "teaching")
public class Teaching extends AbstractTemplate {

    //注意此处不能是private
    static final String TEMPLATE_TYPE = "teaching";

    @Id
    @ExcelProperty("用户id")
    private Integer id;

    @ExcelProperty("标题")
    private String title;

    @JsonSerialize(using = ToStringSerializer.class)
    private String uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String name;

    private String source;

    private String type;

    private String level;

    private String projectTime;

    private String postProjectTime;

    private String fund;

    @ExcelProperty("参与人")
    private List<String> member;

    //------------------
    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;

}
