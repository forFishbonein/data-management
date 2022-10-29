package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/11
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // 邮件发送人
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;


    /***
     *
     * @param to 邮件接收人
     * @param subject 标题
     * @param context 内容
     */
    public void sendEmailTemplate(String to, String subject, String context) {
        System.out.println(from);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(context);

        //发送邮件操作
        mailSender.send(mailMessage);
    }
//    @Test
//    public void test() {
//        new EmailService().sendEmailTemplate("1111@qq.com","1111","1111");
//    }

}
