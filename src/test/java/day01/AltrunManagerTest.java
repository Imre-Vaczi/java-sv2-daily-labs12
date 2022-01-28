package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AltrunManagerTest {

    @Test
    void testSumRuns() {
        AltrunManager arm = new AltrunManager("src/test/resources/running.csv");
        double result = arm.sumRuns(2021,12);
        assertEquals(41.2, result);
    }

}