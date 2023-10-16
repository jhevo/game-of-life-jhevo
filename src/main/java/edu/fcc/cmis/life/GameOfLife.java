package edu.fcc.cmis.life;

import edu.fcc.cmis.life.game.World;
import edu.fcc.cmis.life.ui.CellTable;

import javax.swing.*;
import java.awt.*;

public class GameOfLife {

    private static final int LENGTH = 500;
    private static final int REFRESH = 100; // in millis
    private static final int N = 32;

    private static final String TITLE = "Game of Life";

    private static void start() {
        final JPanel grid = new JPanel(new BorderLayout());
        final World world = new World(N);
        final CellTable table = new CellTable(world, N);
        grid.add(table, BorderLayout.CENTER);

        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        final JFrame frame = new JFrame(TITLE);
        final Dimension d = new Dimension(LENGTH, LENGTH);
        frame.setPreferredSize(d);
        frame.setMinimumSize(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(centeredGrid);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        Timer timer = new Timer(REFRESH, e -> table.update());
        timer.start();
        timer.setRepeats(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameOfLife::start);
    }
}
