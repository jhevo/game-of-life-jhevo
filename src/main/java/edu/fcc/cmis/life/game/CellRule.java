package edu.fcc.cmis.life.game;

public class CellRule {

    /**
     * Determine the next {@link CellState} for the cell. You could also call this the new 'generation' for
     * the cell.
     *
     * @param current provides the {@link CellState} for a given cell in the world
     * @param neighbors is the number of ALIVE neighbors for the {@param current} cell
     * @return the next {@link CellState} for {@param current}
     */
    public static CellState next(CellState current, long neighbors) {
    if (current == CellState.ALIVE) {
            if (neighbors < 2) {
                current = CellState.DEAD;
            } else if (neighbors == 2 ||  neighbors == 3 ) {
                current = CellState.ALIVE;
            } else if (neighbors > 3) {
                current = CellState.DEAD;
            }

        } else if (current == CellState.DEAD){
            if (neighbors == 3){
                current = CellState.ALIVE;

            } else {
                current = CellState.DEAD;


            }
        }
    return current;
    }
}
