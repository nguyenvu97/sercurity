package org.springframework.boot.mapstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mapstruct.controller.Controller;
import org.springframework.boot.mapstruct.dto.CarDto;
import org.springframework.boot.mapstruct.mapper.CarMapper;
import org.springframework.boot.mapstruct.model.Car;
import org.springframework.boot.mapstruct.model.Category;
import org.springframework.boot.mapstruct.security.AESKeySize;
import org.springframework.boot.mapstruct.security.Sha256;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static org.springframework.boot.mapstruct.security.AESEcryptionUtils.*;

@SpringBootApplication
@RequiredArgsConstructor
public class MapstructApplication {


    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        SpringApplication.run(MapstructApplication.class, args);
        String txt = "abc1234";
        SecretKey secretKey = generatorKey(AESKeySize.SIZE_256);
        IvParameterSpec parameterSpec = genSpec();
        String abc = encrypt(AES_ALGORITHM,txt, secretKey,parameterSpec);
        System.out.printf("Encrypt" + abc);

        String decryptedText = decrypt(abc, secretKey, parameterSpec,AES_ALGORITHM);
        System.out.println("Decrypted: " + decryptedText);

    }

}
