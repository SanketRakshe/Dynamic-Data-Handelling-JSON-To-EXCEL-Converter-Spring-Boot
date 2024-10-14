package com.example.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.PersonData;
import com.example.utils.ExcelGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileService {
	
	private final ObjectMapper objectMapper;
    private final ExcelGenerator excelGenerator;

    public FileService(ObjectMapper objectMapper, ExcelGenerator excelGenerator) {
        this.objectMapper = objectMapper;
        this.excelGenerator = excelGenerator;
    }

    public void generateExcelFromJson(String jsonFolderPath, String outputExcelPath) throws IOException {
        List<PersonData> personDataList = new ArrayList<>();
        
        File folder = new File(jsonFolderPath);
        File[] jsonFiles = folder.listFiles();

        if (jsonFiles != null) {
            for (File jsonFile : jsonFiles) {
                if (jsonFile.isFile() && jsonFile.getName().endsWith(".json")) {
                    PersonData personData = objectMapper.readValue(jsonFile, PersonData.class);
                    personDataList.add(personData);
                }
            }
        }
        
        // Call to generate Excel file
        excelGenerator.generateExcel(personDataList, outputExcelPath);
    }
}
