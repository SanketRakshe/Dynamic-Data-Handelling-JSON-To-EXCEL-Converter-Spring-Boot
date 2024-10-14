package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/generate-excel")
    public String generateExcel(@RequestParam String jsonFolderPath, @RequestParam String outputExcelPath) {
        try {
            fileService.generateExcelFromJson(jsonFolderPath, outputExcelPath);
            return "Excel file generated successfully!";
        } catch (IOException e) {
            return "Error generating Excel file: " + e.getMessage();
        }
    }
}