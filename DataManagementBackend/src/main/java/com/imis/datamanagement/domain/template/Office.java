package com.imis.datamanagement.domain.template;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class Office extends AbstractTemplate {
    static final String TEMPLATE_TYPE = "office";
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long uploaderId;

    private String num;

    private String introduction;


    private String time;

    private String type;

    private String topic;

    private String content;

    private String address;

    private String participant;


    private Map<String, String> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
