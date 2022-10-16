package com.imis.datamanagement.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class Contest implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long contestId;

    private String contestName;

    private String contestLink;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
