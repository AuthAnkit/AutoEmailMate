package com.AutoEmailMate.eg.Service.ServiceImpl;

import com.AutoEmailMate.eg.DTO.RecuriterDTO;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    public List<RecuriterDTO> readCsvFile(MultipartFile file) throws Exception {
        List<RecuriterDTO> list = new ArrayList<>();
        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        reader.readNext();
        String [] row;
        while ((row = reader.readNext()) != null) {
            if(row.length < 4){
                continue;
            }
            RecuriterDTO recuriterDTO = new RecuriterDTO(row[0].trim(),row[1].trim(),row[2].trim(),row[3].trim());
            list.add(recuriterDTO);
        }
        return list;
        }
    }
