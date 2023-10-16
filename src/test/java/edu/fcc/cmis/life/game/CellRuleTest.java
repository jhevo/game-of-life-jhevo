package edu.fcc.cmis.life.game;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("game")
public class CellRuleTest {

    @ParameterizedTest(name = "A cell with state {0} with {1} neighbors should become {2}")
    @MethodSource("game")
    void check(CellState current, int neighbors, CellState next) {
        assertEquals(next, CellRule.next(current, neighbors));
    }

    @ParameterizedTest(name = "A cell with state {0} with {1} neighbors should become {2}")

    @MethodSource("sustain")
    void checkSustain(CellState current, int neighbors, CellState next) {
        assertEquals(next, CellRule.next(current, neighbors));
    }

    @ParameterizedTest(name = "A cell with state {0} with {1} neighbors should become {2}")
    @MethodSource("overpopulation")

    void checkOverpopulation(CellState current, int neighbors, CellState next) {
        assertEquals(next, CellRule.next(current, neighbors));
    }

    private static Stream<Arguments> sustain(){
        return Stream.of(
                // sustain
                arguments(CellState.ALIVE, 2, CellState.ALIVE),
                arguments(CellState.ALIVE, 3, CellState.ALIVE)
        );
    }

    private static Stream<Arguments> overpopulation(){
        return Stream.of(
                // over population
                arguments(CellState.ALIVE, 4, CellState.DEAD),
                arguments(CellState.ALIVE, 5, CellState.DEAD),
                arguments(CellState.ALIVE, 6, CellState.DEAD),
                arguments(CellState.ALIVE, 7, CellState.DEAD),
                arguments(CellState.ALIVE, 8, CellState.DEAD)
        );
    }

    private static Stream<Arguments> game() {
        return Stream.of(
                // underpopulation
                arguments(CellState.ALIVE, 1, CellState.DEAD),
                arguments(CellState.ALIVE, 0, CellState.DEAD),

                // exactly 3 to reproduce
                arguments(CellState.DEAD, 3, CellState.ALIVE),
                arguments(CellState.DEAD, 0, CellState.DEAD),
                arguments(CellState.DEAD, 1, CellState.DEAD),
                arguments(CellState.DEAD, 2, CellState.DEAD),
                arguments(CellState.DEAD, 4, CellState.DEAD),
                arguments(CellState.DEAD, 5, CellState.DEAD),
                arguments(CellState.DEAD, 6, CellState.DEAD),
                arguments(CellState.DEAD, 7, CellState.DEAD),
                arguments(CellState.DEAD, 8, CellState.DEAD)
        );
    }
}
