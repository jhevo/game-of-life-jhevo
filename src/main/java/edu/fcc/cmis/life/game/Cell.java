package edu.fcc.cmis.life.game;

import java.util.stream.Stream;

/**
 * The state of a single life or a single cell in the table of Game of Life that is managed by {@link World}
 */
public class Cell {
    private final World world;
    private CellState state, next;

    public Cell(CellState state, World world) {
        this.state = state;
        this.world = world;
    }

    public CellState getState() {
        return state;
    }

    public void update() {
        long n = Stream.of(
                world.cellStateForNeighbor(this, Neighbor.TOP),
                world.cellStateForNeighbor(this, Neighbor.BOTTOM),
                world.cellStateForNeighbor(this, Neighbor.RIGHT),
                world.cellStateForNeighbor(this, Neighbor.LEFT),
                world.cellStateForNeighbor(this, Neighbor.TOP_LEFT),
                world.cellStateForNeighbor(this, Neighbor.TOP_RIGHT),
                world.cellStateForNeighbor(this, Neighbor.BOTTOM_LEFT),
                world.cellStateForNeighbor(this, Neighbor.BOTTOM_RIGHT)
        ).filter(c -> c == CellState.ALIVE).count();

        this.next = CellRule.next(state, n);
    }

    public void next() {
        this.state = next;
    }
}
