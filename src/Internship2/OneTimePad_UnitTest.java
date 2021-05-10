package Internship2;

import org.junit.jupiter.api.*;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneTimePad_UnitTest {

    private String plainText1;
    private String key1;
    private long   counter;

    @BeforeEach
    void setUp(){
        this.plainText1 = "Hello World";
        this.key1       = "supersecret";
    }

    @AfterEach
    void tearDown(){
        this.plainText1 = null;
        this.key1 = null;
        this.counter = 0l;
    }




    @Test
    @DisplayName("tests, if the string -> hex conversion works")
    void testStringToHex(){
        assertEquals("48656c6c6f20576f726c64", OneTimePad.stringToHexString(this.plainText1), "damn! something went wrong - no." + ++counter);
        assertEquals("7375706572736563726574", OneTimePad.stringToHexString(this.key1), "damn! something went wrong - no." + ++counter);

    }


    @Test
    @DisplayName("tests, if XORing two strings works correctly")
    void testXorHexStrings(){
        assertEquals(new BigInteger("3b101c091d53320c000910", 16).toString(), OneTimePad.xorHexStrings("48656c6c6f20576f726c64", "7375706572736563726574"), "damn! something went wrong - no." + ++counter);
    }

    @Disabled
    @Test
    @DisplayName("tests, if the plain text is correctly encrypted")
    void testEncryption(){
        assertEquals("EQNVZ", OneTimePad.encrypt(this.plainText1, this.key1),"damn! something went wrong - no." + ++counter);
    }

    @Disabled
    @Test
    @DisplayName("tests, if the cipher text is correctly decrypted")
    void testDecryption(){
        assertEquals("HELLO", OneTimePad.decrypt(OneTimePad.encrypt(this.plainText1, this.key1), this.key1), "damn! something went wrong - no." + ++counter);
    }
}
