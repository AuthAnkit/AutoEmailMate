package com.AutoEmailMate.eg.Controller;

import com.AutoEmailMate.eg.DTO.RecuriterDTO;
import com.AutoEmailMate.eg.DTO.request.EmailRequest;
import com.AutoEmailMate.eg.Service.EmailService;
import com.AutoEmailMate.eg.Service.ServiceImpl.BulkEmailSenderService;
import com.AutoEmailMate.eg.Util.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")

public class EmailController {
    private final EmailService emailService;
    private final CSVReader csvReader;
    private  final BulkEmailSenderService  bulkEmailSenderService;
    @PostMapping("/upload-csv")
    public ResponseEntity<List<String>> uploadCsv(@RequestParam("file") MultipartFile file) throws Exception {
        List<String> emails = csvReader.readEmails(file);
        return ResponseEntity.ok(emails);
    }

    @PostMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequest emailRequest) {
        String mess = emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
        return ResponseEntity.ok(mess);
    }

    @PostMapping("/send-mail-with-attachment")
    public ResponseEntity<String> sendMailWithAttachment(@RequestParam("to") String to,
                                             @RequestParam("subject") String subject,
                                             @RequestParam("message") String message,
                                             @RequestParam("file") MultipartFile file) throws Exception {
        String mess = emailService.sendEmailWithAttachment(to, subject, message, file);
        return ResponseEntity.ok(mess);
    }

    @PostMapping("/send-bulk")
    public ResponseEntity<String> sendBulk(@RequestParam("csv")  MultipartFile file,
                                             @RequestParam("resume") MultipartFile resume,
                                             @RequestParam("subject") String subject
    ) throws Exception {
        String response = bulkEmailSenderService.SendBulkEmails(file,resume,subject);
        return ResponseEntity.ok(response);
    }
}
