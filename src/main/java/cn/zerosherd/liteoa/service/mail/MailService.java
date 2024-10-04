package cn.zerosherd.liteoa.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送纯文本邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 发送HTML邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param html    HTML内容
     */
    public void sendHtmlMessage(String to, String subject, String html) throws MessagingException {
        // 这里我们使用JavaMailSenderImpl来发送HTML邮件
        // 注意，你需要在JavaMailSenderImpl中设置支持HTML的属性
        mailSender.send(createHtmlMessage(to, subject, html));
    }

    private MimeMessage createHtmlMessage(String to, String subject, String html) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true); // 设置为true表示是HTML格式
        return message;
    }

}
