package Internship2;

import org.junit.jupiter.api.*;

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
    @DisplayName("tests, if the ASCII string -> hex string conversion works like intended")
    void testAsciiStringToHexString(){
        assertEquals("48656c6c6f20576f726c64", OneTimePad.asciiStringToHexString(this.plainText1), "damn! something went wrong - no." + ++counter);
        assertEquals("7375706572736563726574", OneTimePad.asciiStringToHexString(this.key1), "damn! something went wrong - no." + ++counter);
    }


    @Test
    @DisplayName("tests, if the hex string -> ASCII string conversion works like intended")
    void testHexStringToAsciiString(){
        assertEquals("ZYAPFOSTCH", OneTimePad.hexStringToAsciiString(this.key1), "damn! something went wrong - no." + ++counter);
    }




    @Test
    @DisplayName("tests, if XORing two strings works like intended")
    void testXorHexStrings(){
        assertEquals("3b101c091d53320c000910", OneTimePad.xorHexStrings("48656c6c6f20576f726c64", "7375706572736563726574"), "damn! something went wrong - no." + ++counter);
    }


    @Test
    @DisplayName("tests, if the plain text is correctly encrypted")
    void testEncryption(){
        assertEquals("3b101c091d53320c000910", OneTimePad.encrypt(this.plainText1, this.key1),"damn! something went wrong - no." + ++counter);
    }


    @Disabled
    @Test
    @DisplayName("tests, if the cipher text is correctly decrypted")
    void testDecryption(){
        assertEquals("HELLO", OneTimePad.decrypt(OneTimePad.encrypt(this.plainText1, this.key1), this.key1), "damn! something went wrong - no." + ++counter);
    }
}
