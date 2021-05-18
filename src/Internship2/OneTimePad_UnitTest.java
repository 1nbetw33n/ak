package Internship2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneTimePad_UnitTest {

    private String plainText1;
    private String plainText2;
    private String key1;
    private String key2;
    private String cipher1;
    private long   counter;


    @BeforeEach
    @DisplayName("initializing instance variables")
    void setUp(){
        this.plainText1 = "Hello World";
        this.plainText2 = "Operation start at 10:00";
        this.key1       = "supersecret";
        this.key2       = "a33a986b3f8b111dfbfb1d2e6f0934748fba6efc07a9fab9";
        this.cipher1    = "ec4afd195eff787295db6e5a0e7b4054eece4ecd3793ca89";
    }


    @AfterEach
    @DisplayName("de-referencing instance variables ")
    void tearDown(){
        this.plainText1 = null;
        this.plainText2 = null;
        this.key1 = null;
        this.key2 = null;
        this.cipher1 = null;
        this.counter = 0l;
    }


    @Test
    @DisplayName("tests, if the ASCII string -> hex string conversion works like intended")
    void testAsciiStringToHexString(){
        assertEquals("48656c6c6f20576f726c64", OneTimePad.asciiStringToHexString(this.plainText1), "damn! something went wrong - no." + ++counter);
        assertEquals("7375706572736563726574", OneTimePad.asciiStringToHexString(this.key1), "damn! something went wrong - no." + ++counter);
        assertEquals("4f7065726174696f6e2073746172742061742031303a3030", OneTimePad.asciiStringToHexString(this.plainText2), "damn! something went wrong - no." + ++counter);
    }


    @Test
    @DisplayName("tests, if the hex string -> ASCII string conversion works like intended")
    void testHexStringToAsciiString(){
        assertEquals(this.key1, OneTimePad.hexStringToAsciiString("7375706572736563726574"), "damn! something went wrong - no." + ++counter);
        assertEquals(this.plainText1, OneTimePad.hexStringToAsciiString("48656c6c6f20576f726c64"), "damn! something went wrong - no." + ++counter);
        assertEquals(this.plainText2, OneTimePad.hexStringToAsciiString("4f7065726174696f6e2073746172742061742031303a3030"), "damn! something went wrong - no." + ++counter);
    }


    @Test
    @DisplayName("tests, if XORing two strings works like intended")
    void testXorHexStrings(){
        assertEquals("3b101c091d53320c000910", OneTimePad.xorHexStrings("48656c6c6f20576f726c64", "7375706572736563726574"), "damn! something went wrong - no." + ++counter);
        assertEquals("ec4afd195eff787295db6e5a0e7b4054eece4ecd3793ca89", OneTimePad.xorHexStrings("4f7065726174696f6e2073746172742061742031303a3030", "a33a986b3f8b111dfbfb1d2e6f0934748fba6efc07a9fab9"), "damn! something went wrong - no." + ++counter);
        assertEquals("4f7065726174696f6e2073746172742061742031303a3030", OneTimePad.xorHexStrings("ec4afd195eff787295db6e5a0e7b4054eece4ecd3793ca89", "a33a986b3f8b111dfbfb1d2e6f0934748fba6efc07a9fab9"), "damn! something went wrong - no." + ++counter);

    }


    @Test
    @DisplayName("tests, if the plain text is correctly encrypted")
    void testEncryption(){
        assertEquals("3b101c091d53320c000910", OneTimePad.encrypt(this.plainText1, this.key1),"damn! something went wrong - no." + ++counter);
    }



    @Test
    @DisplayName("tests, if the cipher text is correctly decrypted")
    void testDecryption(){
        assertEquals("4f7065726174696f6e2073746172742061742031303a3030", OneTimePad.decrypt(this.cipher1, this.key2), "damn! something went wrong - no." + ++counter);
    }
}
