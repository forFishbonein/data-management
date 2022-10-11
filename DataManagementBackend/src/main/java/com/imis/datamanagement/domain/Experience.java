package com.imis.datamanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;


@Data
public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long experienceId;

    private Long contestId;

    private String experienceContent;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
