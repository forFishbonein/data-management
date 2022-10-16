package com.imis.datamanagement.domain.template;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "contest")
public class StudentContest extends AbstractTemplate{

    static final String TEMPLATE_TYPE = "contest";

    @Id
    private Integer id;

    private Long uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String name;

    private String gameName;

    private String grade;

    private String instructor;

    private String time;

    //------------------
    private Map<String, String> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;

}
