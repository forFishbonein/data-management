package com.imis.datamanagement.domain.template;
/*
 *
 * @Time : 2022/10/14
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "TEMPLATE_TYPE",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Achievememnt.class, name = Achievememnt.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Communication.class, name = Communication.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Honor.class, name = Honor.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Office.class, name = Office.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Paper.class, name = Paper.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Party.class, name = Party.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = StudentContest.class, name = StudentContest.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Teaching.class, name = Teaching.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = UserDefined.class, name = UserDefined.TEMPLATE_TYPE)
})
@Data
public abstract class AbstractTemplate {
    String TEMPLATE_TYPE;

    Integer id;

    @Field("a_other")
    Map<String, String> other;

    @Field("a_filePath")
    List<String> filePath;

    @Field("a_createTime")
    String createTime;

    @Field("a_updateTime")
    String updateTime;

    @Field("a_deleted")
    String deleted;
}
