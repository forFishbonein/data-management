package com.imis.datamanagement.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.datamanagement.common.R;
import com.imis.datamanagement.domain.User;

public interface UserService extends IService<User> {
    //发送邮件
    void sendEmail(String to, String subject, String context);
}
