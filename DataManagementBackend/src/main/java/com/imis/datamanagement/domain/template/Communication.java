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
@Document(collection = "communication")
public class Communication extends AbstractTemplate {

    static final String TEMPLATE_TYPE = "communication";

    @Id
    private Integer id;

    private String title;

    @JsonSerialize(using = ToStringSerializer.class)
    private String uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String startTime;

    private String lastTime;

    private String type;

    private String name;

    private String organizer;

    private String address;

    private List<String> member;

    private String whetherSpeak;

    private String whetherParticipate;

    //------------------
    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;
}
