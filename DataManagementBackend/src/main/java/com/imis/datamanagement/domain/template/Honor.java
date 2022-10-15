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
@Document(collection = "honor")
public class Honor extends AbstractTemplate{

    static final String TEMPLATE_TYPE = "honor";

    @Id
    private Integer id;

    private Long uploaderId;

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

    private String member;

    //------------------
    @Field("honor_other")
    private Map<String, String> other;

    @Field("honor_filePath")
    private List<String> filePath;

    @Field("honor_createTime")
    private String createTime;

    @Field("honor_updateTime")
    private String updateTime;

    @Value("0")
    @Field("honor_deleted")
    private String deleted;

}
