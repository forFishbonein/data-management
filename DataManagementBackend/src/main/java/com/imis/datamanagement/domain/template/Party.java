package com.imis.datamanagement.domain.template;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "party")
public class Party extends AbstractTemplate{


    static final String TEMPLATE_TYPE = "party";

    @Id
    private Long id;

    private Long uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String time;

    private String type;

    private String topic;

    private String content;

    private String address;

    private String participant;

    //------------------
    private Map<String, String> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;
}
