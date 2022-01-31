package edu.aziko.cipher.algos.vernam;

import static edu.aziko.cipher.algos.mapper.StreamDecoder.decodeFromIntStreamToString;

public class VernamCipher {

    private final int[] KEY;

    public VernamCipher(int[] key) {
        this.KEY = key;
    }

    public String crypt(String plainText) {
        return doVernamCipherAlgo(plainText);
    }

    public String decrypt(String cipherText) {
        return doVernamCipherAlgo(cipherText);
    }

    private String doVernamCipherAlgo(String cipherText) {
        int[] cipherTextStream = cipherText.chars().toArray();
        int[] decryptedTextStream = new int[cipherTextStream.length];
        for (int i = 0; i < cipherTextStream.length; i++) {
            int decryptedValue = cipherTextStream[i] ^ KEY[i % KEY.length];
            decryptedTextStream[i] = decryptedValue;
        }
        String decryptedText = decodeFromIntStreamToString(decryptedTextStream);
        return decryptedText;
    }
}
