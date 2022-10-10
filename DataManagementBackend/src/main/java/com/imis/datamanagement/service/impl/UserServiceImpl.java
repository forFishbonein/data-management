package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.mapper.UserMapper;
import com.imis.datamanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    // 邮件发送人
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String context) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        //发送人
        mailMessage.setFrom(from);
        //接收人
        mailMessage.setTo(to);
        //标题
        mailMessage.setSubject(subject);
        //内容
        mailMessage.setText(context);

        //发送邮件操作，从 from到 to
        mailSender.send(mailMessage);
    }
}
