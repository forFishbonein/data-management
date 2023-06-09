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
@Document(collection = "honor")
public class Honor extends AbstractTemplate{

    static final String TEMPLATE_TYPE = "honor";

    @Id
    private Integer id;

    private String title;

    @JsonSerialize(using = ToStringSerializer.class)
    private String uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String award_name;

    private String time;

    private String type;

    private String garde;

    private String level;

    private String name;

    private String approval_num;

    private List<String> member;

    //------------------
    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;

}
