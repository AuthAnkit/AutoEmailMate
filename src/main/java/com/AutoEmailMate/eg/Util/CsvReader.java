package com.AutoEmailMate.eg.Util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

@Component
public class CsvReader {
    public List<String> readEmails(MultipartFile file) throws Exception {
        List<String> emails = new ArrayList<String>();


        InputStreamReader reader = new InputStreamReader(file.getInputStream());

        CSVReader csvReader = new CSVReader(reader);
        csvReader.readNext();
        String[] row;
        while ((row = csvReader.readNext()) != null) {
            emails.add(row[3]);
        }

        return emails;
    }
}
