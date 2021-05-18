package intern3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFSRTest {

    private Long counter;
    private byte[] bytestream1;
    private LFSR lfsr1;

    @BeforeEach
    void setUp() {
        this.counter = 0L;
        this.bytestream1 = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0};
        this.lfsr1 = new LFSR("0x1FFFFF");
    }

    @AfterEach
    void tearDown() {
       this.counter = null;
       this.bytestream1 = null;
       this.lfsr1 = null;
    }

    @Test
    @DisplayName("Tests, if the method returns the correct byte stream")
    void testGenerateByteStream() {
        assertEquals(this.bytestream1, this.lfsr1.generateByteStream(), "damn! something works not like intended - no." + ++counter);
    }
}