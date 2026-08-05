package com.AutoEmailMate.eg.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public  String sendEmailWithAttachment(String to , String subject, String message , MultipartFile resume)throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("authankit@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message);
        helper.addAttachment(resume.getOriginalFilename(),new ByteArrayResource(resume.getBytes()));
        mailSender.send(mimeMessage);
        if(resume.isEmpty()){
            throw new RuntimeException("Resume file is empty");
        }
        return "Mail sent successfully with attachment";
            }


}
