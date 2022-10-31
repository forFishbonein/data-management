package com.imis.datamanagement.domain.template;


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
@Document(collection = "user_defined")
public class UserDefined extends AbstractTemplate{


    static final String TEMPLATE_TYPE = "userdefined";

    @Id
    private Integer id;

    private String title;

    @JsonSerialize(using = ToStringSerializer.class)
    private String uploaderId;

    private String num;

    private String introduction;

    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;
}
