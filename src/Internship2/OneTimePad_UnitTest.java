package Internship2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OneTimePad_UnitTest {

    private String plainText;
    private String key;
    private long   counter;

    @BeforeEach
    void setUp(){
        this.plainText = "Hello World";
        this.key       = "XMCKL";
    }

    @AfterEach
    void tearDown(){
        this.plainText = null;
        this.key = null;
        this.counter = 0l;
    }

    @Test
    @DisplayName("tests, if the string -> hex conversion works")
    void testStringToHex(){
        assertEquals("48656c6c6f20576f726c64", OneTimePad.stringToHex(this.plainText), "damn! something went wrong - no." + ++counter);

    }

    @Disabled
    @Test
    @DisplayName("test, if the plain text is correctly encrypted")
    void testEncryption(){
        assertEquals("EQNVZ", OneTimePad.encrypt(this.plainText, this.key),"damn! something went wrong - no." + ++counter);
    }

    @Disabled
    @Test
    @DisplayName("test, if the cipher text is correctly decrypted")
    void testDecryption(){
        assertEquals("HELLO", OneTimePad.decrypt(OneTimePad.encrypt(this.plainText, this.key), this.key), "damn! something went wrong - no." + ++counter);
    }
}
