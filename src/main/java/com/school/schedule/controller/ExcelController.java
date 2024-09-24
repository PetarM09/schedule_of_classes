package com.school.schedule.controller;
import com.school.schedule.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            // Ne čuvamo fajl na disk, već ga direktno prosleđujemo servisu
            excelImportService.importDataFromExcel(file);
            return "Data successfully imported";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error importing data: " + e.getMessage();
        }
    }
}