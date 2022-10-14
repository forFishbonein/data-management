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
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class Honor extends AbstractTemplate{

    static final String TEMPLATE_TYPE = "honor";

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long uploaderId;

    private String num;

    private String introduction;

    //------------------
    private String award_name;

    private String time;

    private String type;

    private String garde;

    private String level;

    private String name;

    private String approval_num;

    private String member;

    //------------------
    private Map<String, String> other;

    private String createTime;

    private String updateTime;

    @TableLogic
    private String deleted;

}
