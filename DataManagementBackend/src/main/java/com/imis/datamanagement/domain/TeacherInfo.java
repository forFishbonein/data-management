package com.imis.datamanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class TeacherInfo {
    private static final long serialVersionUID = 1L;

    //使用MP的id生成策略
    @TableId(type = IdType.ASSIGN_ID)
    private Long teacherId;

    private String teacherSid;

    private String teacherName;

    private String teacherTitle;

    private String teacherTele;

}
