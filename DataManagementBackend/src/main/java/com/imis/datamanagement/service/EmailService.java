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
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    // 邮件发送人
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;

    public ResponseEntity<String> sendMimeMail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            Context context = new Context();
            //设置传入模板的页面的参数 参数名为:id 参数随便写一个就行
            context.setVariable("message", content);
            System.out.println(content);
            //emailTemplate是你要发送的模板我这里用的是Thymeleaf
            String process = templateEngine.process("emailDemo", context);
            //邮件内容，html格式
            helper.setText(process, true);
            mailSender.send(mimeMessage);
            return ResponseEntity.status(HttpStatus.CREATED).body("发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("e.getMessage()");
        }
    }
    /***
     *
     * @param to 邮件接收人
     * @param subject 标题
     * @param context 内容
     */
}
