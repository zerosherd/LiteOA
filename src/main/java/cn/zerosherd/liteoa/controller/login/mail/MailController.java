package cn.zerosherd.liteoa.controller.login.mail;

import cn.zerosherd.liteoa.service.mail.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendTextEmail")
    public String sendTextEmail(String receiver, String title, String content) throws MessagingException {
        // 发送纯文本邮件
        mailService.sendSimpleMessage(receiver, title, content);

        return "Email sent.";
    }

    @GetMapping("/sendHtmlEmail")
    public String sendHtmlEmail(String receiver, String title, String content) throws MessagingException {
        // 发送HTML邮件
        mailService.sendHtmlMessage(receiver, title, content);

        return "Email sent.";
    }

}
