/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PasswordManagement;

/**
 *
 * @author Tanya
 */

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class PasswordManager {
    private static final int HASHING_ITERATIONS = 10000;
    private static final int SALT_LENGTH = 16;
    private static final int HASH_LENGTH = 32;

    private byte[] salt;
    private byte[] hashedPassword;
            
    public PasswordManager(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(password, this.salt);
    }

    private byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, HASHING_ITERATIONS);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); // Specify the algorithm
        SecretKey key = f.generateSecret(spec);
        byte[] hash = key.getEncoded();
        return hash;
    }

    public boolean authenticate(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] inputHash = hashPassword(password, this.salt);
        return Arrays.equals(inputHash, this.hashedPassword);
    }

    public String getSaltBase64() {
        return Base64.getEncoder().encodeToString(this.salt);
    }

    public String getHashBase64() {
        return Base64.getEncoder().encodeToString(this.hashedPassword);
    }
}
    
