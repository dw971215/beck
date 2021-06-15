package com.beck.common.utils.email;

import com.beck.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * @describe 邮件发送
 * @author: dawei
 * @date 2021/5/15 12:16
 */
@Component
public class EmailUtils {

    private static JavaMailSender mailSender = null;

    private static String fromUser;

    @Value("${spring.mail.username}")
    private String fromEmail;

    static {
        mailSender = SpringUtils.getBean(JavaMailSender.class);
    }

    @PostConstruct
    public void  init(){
        fromUser = this.fromEmail;
    }


    /**
     *
     * @param subject 主题
     * @param message 内容
     * @param toUser  接收人
     */
    public static void sendMsg(String subject,String message,String[] toUser) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromUser);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(message);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param subject 主题
     * @param message 内容
     * @param fromUser 发送人
     * @param toUser  接收人
     */
    public static void sendMessage(String subject,String message,String fromUser,String[] toUser) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromUser);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(message);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送邮件给特定的人
     * 使用html方式发送
     * @param subject
     * @param message
     */
    public static void sendHtmlMessage(String subject,String message,String fromUser,String[] toUser){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromUser);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(message,true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }








}
