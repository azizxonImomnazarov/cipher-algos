package algos.vernam;

import edu.aziko.cipher.algos.vernam.VernamCipher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
