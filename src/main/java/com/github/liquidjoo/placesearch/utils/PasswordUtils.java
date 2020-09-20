package com.github.liquidjoo.placesearch.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordUtils {

    private static final String SALT = "SECRET_KEY";
    private static final String TYPE = "PBKDF2WithHmacSHA1";

    private static byte[] encrypt(char[] password) {
        KeySpec spec = new PBEKeySpec(password, SALT.getBytes(), 65536, 128);

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(TYPE);
            return factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static String generatePasswordBySecure(String password) {
        final byte[] securePassword = encrypt(password.toCharArray());
        return Base64.getEncoder().encodeToString(securePassword);
    }
}
