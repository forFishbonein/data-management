package com.imis.datamanagement.common.vo;
/*
 *
 * @Time : 2022/10/17
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class ShowVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private String teacherId;

    private String teacherEmail;

    private String teacherPass;

    private String teacherSid;

    private String teacherName;

    private String teacherTitle;

    private String teacherTele;

}
