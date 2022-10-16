package com.imis.datamanagement.domain.template;
/*
 *
 * @Time : 2022/10/13
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "teaching")
public class Teaching extends AbstractTemplate {

    //注意此处不能是private
    static final String TEMPLATE_TYPE = "teaching";

    @Id
    private Integer id;

    private Long uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String name;

    private String source;

    private String type;

    private String level;

    private String projectTime;

    private String fund;

    private String member;

    //------------------
    @Field("teaching_other")
    private Map<String, String> other;

    @Field("teaching_filePath")
    private List<String> filePath;

    @Field("teaching_createTime")
    private String createTime;

    @Field("teaching_updateTime")
    private String updateTime;

    @Value("0")
    @Field("teaching_deleted")
    private String deleted;


}
