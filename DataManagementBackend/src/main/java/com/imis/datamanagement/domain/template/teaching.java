package com.imis.datamanagement.domain.template;
/*
 *
 * @Time : 2022/10/13
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class teaching {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long uploader_id;

    private String num;

    private String introduction;

    private String name;

    private String source;

    private String type;

    private String level;

    private String project_time;

    private String fund;

    private String member;

    private String other;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;

}
