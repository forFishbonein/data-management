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
public class Achievememnt extends AbstractTemplate{
    static final String TEMPLATE_TYPE = "achievement";
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String name;

    private String author;

    private String publicYear;

    private String paper;

    private String type;

    private String press;

    private String journalGrade;

    private String schoolGrade;

    private String publicationTime;

    private String authorRank;

    //------------------
    private Map<String, String> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;

}
