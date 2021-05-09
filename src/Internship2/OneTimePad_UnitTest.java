package Internship2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OneTimePad_UnitTest {

    private String plainText;
    private String key;
    private long   counter;

    @BeforeEach
    void setUp(){
        this.plainText = "HELLO";
        this.key       = "XMCKL";
    }

    @AfterEach
    void tearDown(){
        this.plainText = null;
        this.key = null;
        this.counter = 0l;
    }

    @Test
    @DisplayName("test, if the plain text is correctly encrypted")
    void testEncryption(){
        assertEquals("EQNVZ", OneTimePad.encrypt(this.plainText, this.key),"oops, something went wrong no." + ++counter);
    }

    @Test
    @DisplayName("test, if the cipher text is correctly decrypted")
    void testDecryption(){
        assertEquals("HELLO", OneTimePad.decrypt(OneTimePad.encrypt(this.plainText, this.key), this.key), "oops, something went wrong no." + ++counter);
    }
}
