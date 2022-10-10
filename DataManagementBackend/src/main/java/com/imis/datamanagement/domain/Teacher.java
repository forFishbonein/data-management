package com.imis.datamanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


@Data
public class Teacher {
    private static final long serialVersionUID = 1L;

    //使用MP的id生成策略
    @TableId(type = IdType.ASSIGN_ID)
    private Long teacherId;

    private String teacherEmail;

    private String teacherPass;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
