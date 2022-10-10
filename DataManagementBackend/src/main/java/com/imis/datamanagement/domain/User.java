package com.imis.datamanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


@Data
public class User {
    private static final long serialVersionUID = 1L;

    //使用MP的id生成策略
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;

    private String userEmail;

    private String userPass;

    private String userSid;

    private String userName;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;
}
