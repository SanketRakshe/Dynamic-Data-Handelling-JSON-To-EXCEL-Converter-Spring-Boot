package com.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.example.model.PersonData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelGenerator {

    public void generateExcel(List<PersonData> personDataList, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Person Data");

        // Create Header Row
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Id", "Name", "Age", "Gender", "Company", "Address", "PaymentMethod"};
        
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowNum = 1;
        for (PersonData person : personDataList) {
            List<String> addresses = person.getAddress();
            List<String> paymentMethods = person.getPaymentMethod();
            
            for (int i = 0; i < addresses.size(); i++) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(person.getId());
                if (i == 0) {
                    row.createCell(1).setCellValue(person.getName());
                    row.createCell(2).setCellValue(person.getAge());
                    row.createCell(3).setCellValue(person.getGender());
                    row.createCell(4).setCellValue(person.getCompany());
                }
                row.createCell(5).setCellValue(addresses.get(i));
                row.createCell(6).setCellValue(paymentMethods.get(i));
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
}