package algos.vernam;

import edu.aziko.cipher.algos.vernam.VernamCipher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VernamCipherTest {

    @Test
    @DisplayName("Test crypt method")
    public void crypt() {
        String plainText = "KOD";
        String expectedCipherText = "æ5ï";

        VernamCipher vernamCipher = new VernamCipher(new int[]{173, 122, 171});
        String cipherText = vernamCipher.crypt(plainText);

        assertNotNull(cipherText);
        assertEquals(expectedCipherText, cipherText);
    }

    @Test
    @DisplayName("Test decrypt method")
    public void decrypt() {
        String cryptedText = "æ5ï";
        String expectedCipherText = "KOD";

        VernamCipher vernamCipher = new VernamCipher(new int[]{173, 122, 171});
        String decryptText = vernamCipher.decrypt(cryptedText);

        assertNotNull(decryptText);
        assertEquals(expectedCipherText, decryptText);
    }

    @Test
    @DisplayName("Test working crypt and decrypt method together")
    public void cryptDecrypt() {
        List<String> plainTextList = List.of("Azizkhon", "Hello world", "Migration", "Test");
        VernamCipher vernamCipher = new VernamCipher(new int[]{125, 169, 204, 209});

        List<String> decryptedTextList = plainTextList.stream().map(vernamCipher::crypt)
                .map(vernamCipher::decrypt).collect(Collectors.toList());

        assertNotNull(decryptedTextList);

        for (int i = 0; i < plainTextList.size(); i++) {
            assertNotNull(plainTextList.get(i));
            assertNotNull(decryptedTextList.get(i));
            assertEquals(plainTextList.get(i), decryptedTextList.get(i));
        }
    }
}
