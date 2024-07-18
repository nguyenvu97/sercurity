package org.springframework.boot.mapstruct.security;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESEcryptionUtils {
    public static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String encrypt(String algorithm, String input
            ,SecretKey key , IvParameterSpec spec)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);

        cipher.init(Cipher.ENCRYPT_MODE, key ,spec);
        byte[] bytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }


    public static SecretKey  generatorKey(AESKeySize aesKeySize){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(aesKeySize.getVal());
            return generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static IvParameterSpec genSpec(){
        byte[] iv  = new byte[16]; // hardcode
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static String decrypt(String encryptedInput, SecretKey key, IvParameterSpec spec, String algorithm )
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
        return new String(decryptedBytes);
    }

}
