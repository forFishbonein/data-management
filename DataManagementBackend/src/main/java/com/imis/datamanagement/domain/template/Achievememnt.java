package com.imis.datamanagement.domain.template;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "achievement")
public class Achievememnt extends AbstractTemplate{

    static final String TEMPLATE_TYPE = "achievement";

    @Id
    private Integer id;

    private String title;

    private String uploaderId;

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

    private List<String> authorRank;

    //------------------
    private List<Map<String, String>> other;

    private List<String> filePath;

    private String createTime;

    private String updateTime;

    private String deleted;

}
