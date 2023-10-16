package edu.fcc.cmis.life.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BorderRuleTest {

    @Tag("basicBorder")
    @ParameterizedTest(name = "Incoming value of {0} with a max value of {1} should be bounded to {2}")
    @CsvSource(value = {
            "5, 10, 5",
            "9, 10, 9",
    })
    void checkPassthrough(int n, int max, int expected) {
        assertEquals(expected, BorderRule.bound(n, max));
    }

    @Tag("extremeBorder")
    @ParameterizedTest(name = "Incoming value of {0} with a max value of {1} should be bounded to {2}")
    @CsvSource(value = {
            "0, 10, 0",
            "10, 10, 0",
            "12, 10, 0",
            "-1, 10, 9",
            "-2, 10, 9",
            "-1, 20, 19",
    })
    void checkBoundaries(int n, int max, int expected) {
        assertEquals(expected, BorderRule.bound(n, max));
    }
}
