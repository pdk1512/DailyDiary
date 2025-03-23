package com.example.DailyDiary.service.impl;

import com.example.DailyDiary.dto.EmailDetails;
import com.example.DailyDiary.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired private JavaMailSender javaMailSender;
    @Autowired private TemplateEngine templateEngine;
    @Value("${spring.mail.username}") private String sender;
    @Override
    public ResponseEntity<String> sendEmail(EmailDetails emailDetails) {
        try {
            //Binding email template content
            Context context = new Context();
            context.setVariable("emailContent", emailDetails.getEmailContent());
            String emailContent = templateEngine.process("email-template", context);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getEmailSubject());
            mimeMessageHelper.setText(emailContent, true);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error while Sending Mail: " + e.getMessage());
        }
        return ResponseEntity.ok("Mail Sent Successfully!");
    }
}
