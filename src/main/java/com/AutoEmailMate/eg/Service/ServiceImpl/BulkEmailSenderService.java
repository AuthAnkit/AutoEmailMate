package com.AutoEmailMate.eg.Service.ServiceImpl;

import com.AutoEmailMate.eg.DTO.RecuriterDTO;
import com.AutoEmailMate.eg.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BulkEmailSenderService {
    private final EmailService emailService;
    private final CsvService csvService;
    private final MessageGeneratorService messageGeneratorService;
    public String SendBulkEmails(MultipartFile csv , MultipartFile resume , String subject) throws Exception{
        List<RecuriterDTO> list = csvService.readCsvFile(csv);
        for( RecuriterDTO recuriter : list ){
            String personalizedMessage = messageGeneratorService.generateMessage(recuriter);
            emailService.sendEmailWithAttachment(recuriter.getEmail(),subject,personalizedMessage,resume);
        }
        return "Bulk Email Sent Successfully";
    }
}
