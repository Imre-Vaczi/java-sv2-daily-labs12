package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    void testLkoValid() {
        MathAlgorithms ma = new MathAlgorithms();
        int result = ma.lko(25, 15);

        assertEquals(5, result);
    }

    @Test
    void testLkoInvalid() {
        MathAlgorithms ma = new MathAlgorithms();
        int result = ma.lko(16, 29);

        assertEquals(-1, result);
    }
}