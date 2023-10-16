package edu.fcc.cmis.life.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class World {
    private final int n;
    private final Random random;

    private Cell[][] cells;
    private Map<Cell, Coord> lt;

    public World(int n) {
        this.n = n;
        random = new Random();

        initBoard();
    }

    static class Coord {
        public final int i, j;

        public Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private CellState randomState() {
        return random.nextBoolean() ? CellState.ALIVE : CellState.DEAD;
    }

    private void initBoard() {
        cells = new Cell[n][n];
        lt = new HashMap<>();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(randomState(), this);
                lt.put(cells[i][j], new Coord(i, j));
            }
        }
    }

    public CellState cellStateForNeighbor(Cell cell, Neighbor neighbor) {
        Coord coord = lt.get(cell);
        int i = coord.i;
        int j = coord.j;
        switch (neighbor) {
            case TOP:
                return cells[BorderRule.bound(i - 1, n)][j].getState();
            case BOTTOM:
                return cells[BorderRule.bound(i + 1, n)][j].getState();
            case RIGHT:
                return cells[i][BorderRule.bound(j + 1, n)].getState();
            case LEFT:
                return cells[i][BorderRule.bound(j - 1, n)].getState();
            case TOP_LEFT:
                return cells[BorderRule.bound(i - 1, n)][BorderRule.bound(j - 1, n)].getState();
            case TOP_RIGHT:
                return cells[BorderRule.bound(i - 1, n)][BorderRule.bound(j + 1, n)].getState();
            case BOTTOM_LEFT:
                return cells[BorderRule.bound(i + 1, n)][BorderRule.bound(j - 1, n)].getState();
            case BOTTOM_RIGHT:
                return cells[BorderRule.bound(i + 1, n)][BorderRule.bound(j + 1, n)].getState();
            default:
                return CellState.DEAD;
        }
    }

    public void update() {
        lt.keySet().forEach(Cell::update);
        lt.keySet().forEach(Cell::next);
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
}
