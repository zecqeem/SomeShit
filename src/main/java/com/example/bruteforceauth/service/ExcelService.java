package com.example.bruteforceauth.service;

import com.example.bruteforceauth.model.LoginAttempt;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public byte[] generateLoginAttemptsExcel(List<LoginAttempt> attempts) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Login Attempts");
            Row header = sheet.createRow(0);

            String[] columns = {"ID", "Username", "Attempts", "Blocked", "Blocked At"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum = 1;
            for (LoginAttempt attempt : attempts) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(attempt.getId());
                row.createCell(1).setCellValue(attempt.getUsername());
                row.createCell(2).setCellValue(attempt.getAttempts());
                row.createCell(3).setCellValue(attempt.isBlocked());
                row.createCell(4).setCellValue(
                        attempt.getBlockedAt() != null ? attempt.getBlockedAt().toString() : ""
                );
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return out.toByteArray();
        }
    }
}