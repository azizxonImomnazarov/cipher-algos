package edu.aziko.cipher.mapper;

import java.util.stream.IntStream;

public class StreamDecoder {
    public static String decodeFromIntStreamToString(int[] intStream) {
        return IntStream.of(intStream)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int[] decodeFromStringToIntStream(String text) {
        return text.chars().toArray();
    }
}
