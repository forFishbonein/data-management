package com.imis.datamanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    //使用MP的id生成策略
    @TableId(type = IdType.ASSIGN_ID)
    private Long newsId;

    private String newsTitle;

    private String newsEditor;

    private String newsAuthor;

    private String newsSource;

    private String newsView;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
