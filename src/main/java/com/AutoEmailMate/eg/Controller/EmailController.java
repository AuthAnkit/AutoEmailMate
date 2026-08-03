package com.AutoEmailMate.eg.Controller;

import com.AutoEmailMate.eg.Service.EmailService;
import com.AutoEmailMate.eg.Util.CsvReader;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final CsvReader csvReader;
    @PostMapping("/upload-csv")
    public ResponseEntity<List<String>> uploadCsv(@RequestParam("file") MultipartFile file) throws Exception {
        List<String> emails = csvReader.readEmails(file);
        return ResponseEntity.ok(emails);
    }
}
