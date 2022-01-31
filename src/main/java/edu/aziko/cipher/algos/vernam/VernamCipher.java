package edu.aziko.cipher.algos.vernam;

import static edu.aziko.cipher.mapper.StreamDecoder.decodeFromIntStreamToString;
import static edu.aziko.cipher.mapper.StreamDecoder.decodeFromStringToIntStream;
import static edu.aziko.cipher.helper.CipherHelper.xor;

public class VernamCipher {

    private final int[] KEY;

    public VernamCipher(int[] key) {
        this.KEY = key;
    }

    public VernamCipher(String key) {
        this.KEY = decodeFromStringToIntStream(key);
    }

    public String crypt(String plainText) {
        return doVernamCipherAlgo(plainText);
    }

    public String decrypt(String cipherText) {
        return doVernamCipherAlgo(cipherText);
    }

    private String doVernamCipherAlgo(String text) {
        int[] intStreamFromText = decodeFromStringToIntStream(text);
        int[] resultStream = new int[intStreamFromText.length];
        for (int i = 0; i < intStreamFromText.length; i++) {
            resultStream[i] = xor(intStreamFromText[i], KEY[i % KEY.length]);
        }
        String resultText = decodeFromIntStreamToString(resultStream);
        return resultText;
    }
}
