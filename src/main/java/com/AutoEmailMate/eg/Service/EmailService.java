package com.AutoEmailMate.eg.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    public String sendEmail(String to , String subject, String message){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("authankit@gmail.com");
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(message);
        mailSender.send(mail);
        return "Mail sent successfully";
    }


}
