package com.imis.datamanagement.domain.template;
/*
 *
 * @Time : 2022/10/13
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

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
@Document(collection = "studying")
public class Studying extends AbstractTemplate {

    //注意此处不能是private
    static final String TEMPLATE_TYPE = "studying";

    @Id
    private Integer id;

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

    private List<String> member;

    //------------------
    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;

}
