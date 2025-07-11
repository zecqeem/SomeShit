package com.example.bruteforceauth.service;

import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Service
public class ExcelEncryptionService {

    public byte[] encryptWorkbook(byte[] workbookBytes, String password) throws Exception {
        POIFSFileSystem fs = new POIFSFileSystem();
        EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
        Encryptor encryptor = info.getEncryptor();
        encryptor.confirmPassword(password);

        try (
                ByteArrayInputStream bis = new ByteArrayInputStream(workbookBytes);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                OutputStream os = encryptor.getDataStream(fs)
        ) {
            bis.transferTo(os);
            os.close(); // завершает поток для шифрования
            fs.writeFilesystem(bos);
            return bos.toByteArray();
        }
    }
}