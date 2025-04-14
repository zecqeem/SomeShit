package com.example.bruteforceauth.service;

import com.example.bruteforceauth.model.LoginAttempt;
import com.example.bruteforceauth.repository.LoginAttemptRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.List;

@Component
public class ExcelGeneratorOnShutdown {

    private final ExcelService excelService;
    private final LoginAttemptRepository repository;

    public ExcelGeneratorOnShutdown(ExcelService excelService, LoginAttemptRepository repository) {
        this.excelService = excelService;
        this.repository = repository;
    }

    @PreDestroy
    public void generateExcelBeforeShutdown() {
        try {
            List<LoginAttempt> attempts = repository.findAll();
            byte[] data = excelService.generateLoginAttemptsExcel(attempts);

            try (FileOutputStream out = new FileOutputStream("login_attempts.xlsx")) {
                out.write(data);
                System.out.println("Excel file saved before shutdown: login_attempts.xlsx");
            }

        } catch (Exception e) {
            System.err.println("Failed to save Excel file before shutdown: " + e.getMessage());
        }
    }
}