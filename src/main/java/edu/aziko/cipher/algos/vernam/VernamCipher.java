package edu.aziko.cipher.algos.vernam;

import java.util.stream.IntStream;

public class VernamCipher {

    private final int[] KEY;

    public VernamCipher(int[] key) {
        this.KEY = key;
    }

    public String crypt(String plainText) {
        byte[] plainTextBytes = plainText.getBytes();
        int[] cipherTextBytes = new int[plainTextBytes.length];
        for (int i = 0; i < plainTextBytes.length; i++) {
            int cipherTextByte = (plainTextBytes[i] ^ KEY[i]);
            cipherTextBytes[i] = cipherTextByte;
        }
        String cipherText = IntStream.of(cipherTextBytes)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return cipherText;
    }
}
