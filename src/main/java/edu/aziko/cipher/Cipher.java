package edu.aziko.cipher;

public interface Cipher {
    String crypt(String plainText);
    String decrypt(String cipherText);
}
