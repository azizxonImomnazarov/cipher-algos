package edu.aziko.cipher.algos.mapper;

import java.util.stream.IntStream;

public class StreamDecoder {
    public static String decodeFromIntStreamToString(int[] decryptedTextStream) {
        return IntStream.of(decryptedTextStream)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
