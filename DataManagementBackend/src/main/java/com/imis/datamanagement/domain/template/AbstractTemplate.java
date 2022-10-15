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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "TEMPLATE_TYPE",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Teaching.class, name = Teaching.TEMPLATE_TYPE),
        @JsonSubTypes.Type(value = Honor.class, name = Honor.TEMPLATE_TYPE)
})
@Data
public abstract class AbstractTemplate {
    String TEMPLATE_TYPE;

    Integer id;

    Map<String, String> other;

    List<String> filePath;

    String createTime;

    String updateTime;

    @Value("0")
    String deleted;
}
