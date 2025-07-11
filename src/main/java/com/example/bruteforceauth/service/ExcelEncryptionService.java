package com.example.bruteforceauth.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import org.springframework.stereotype.Service;


@Service
public class ExcelEncryptionService {

    public byte[] encryptWorkbook(byte[] workbookBytes, String password) throws Exception {
        // Перетворюємо пароль на 128-бітний AES-ключ
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(password.getBytes("UTF-8"));
        key = Arrays.copyOf(key, 16); // 128-bit ключ

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES"); // AES/ECB/PKCS5Padding — за замовчуванням
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(workbookBytes);
    }
}