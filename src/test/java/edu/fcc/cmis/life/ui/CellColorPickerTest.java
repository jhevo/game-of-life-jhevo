package edu.fcc.cmis.life.ui;

import edu.fcc.cmis.life.game.Cell;
import edu.fcc.cmis.life.game.CellState;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellColorPickerTest {

    @Tag("ui")
    @Test
    void differentColors() {
        Cell c1 = new Cell(CellState.ALIVE, null);
        Cell c2 = new Cell(CellState.DEAD, null);

        assertNotEquals(CellColorPicker.colorForCell(c1), CellColorPicker.colorForCell(c2));
    }
}
