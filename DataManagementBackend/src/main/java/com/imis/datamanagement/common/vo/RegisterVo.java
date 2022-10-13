package com.imis.datamanagement.common.vo;
/*
 *
 * @Time : 2022/10/13
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import lombok.Data;

@Data
public class RegisterVo {
    private String email;

    private String code;

    private String name;

    private String password;

    private String sid;

}
