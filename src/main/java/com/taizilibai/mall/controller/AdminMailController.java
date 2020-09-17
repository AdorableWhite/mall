package com.taizilibai.mall.controller;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;

/**
 * @Description:
 * @Date: 2020/9/14 11:16
 */
@RestController
@RequestMapping("/mail")
public class AdminMailController {


    @Resource
    private JavaMailSender javaMailSender;

    @GetMapping("/send")
    public void testMailSend() {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom("15922028322@163.com");

        //谁要接收
        message.setTo("709590629@qq.com");
        //邮件标题
        message.setSubject("instpower周报");
        //邮件内容
        message.setText("工作内容： ");
        try {
            javaMailSender.send(message);
            System.out.println("发送成功");
        } catch (MailException e) {
            e.printStackTrace();
            System.out.println("普通邮件方失败");
        }
    }

    @GetMapping("/sendConfident")
    public void testConfident() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //谁发的
            message.setFrom("15922028322@163.com");
            //谁要接收
            helper.setTo("709590629@qq.com");
            //邮件标题
            helper.setSubject("LINE 消息日报 " + LocalDate.now());
            String content = LocalDate.now().getMonth()+ "月份消息余额：<i>84848</i><br>";
            helper.setText(content, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
