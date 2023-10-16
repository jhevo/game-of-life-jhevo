package edu.fcc.cmis.life.ui;

import edu.fcc.cmis.life.game.Cell;
import edu.fcc.cmis.life.game.CellState;

import java.awt.*;

public class CellColorPicker {

    /**
     * Pick Java Swing's {@link Color} for a {@link Cell} in a given state
     *
     * @param cell
     * @return
     */
    public static Color colorForCell(Cell cell) {
        CellState current = cell.getState();
        /*
        The Color class has some constants available out of the box, you can just pick them like:
        `return Color.BLACK`

        or

        `Color.YELLOW`

        you need to write logic based on `Cell` to determine which color you want to return.
         */
        throw new UnsupportedOperationException("implement me");
    }
}
