package com.imis.datamanagement.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class news {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID);
    private Long newsId;
    private String newsTitle;
    private String newsEditor;
    private String newsAuthor;
    private String newsSource;
    private String newsView;
    private String creatTime;
    private String updateTime;
    @TableLogic
    private String deleted;
}
