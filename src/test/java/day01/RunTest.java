package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunTest {

    @Test
    void testSumRunDistance() {
        String path = "src/test/resources/running.csv";
        Run run = new Run(path);
        double result = run.sumRunDistance(2021, 12);
        assertEquals(41.2, result);

    }

}