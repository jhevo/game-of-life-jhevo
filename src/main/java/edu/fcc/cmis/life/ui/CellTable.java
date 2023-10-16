package edu.fcc.cmis.life.ui;

import edu.fcc.cmis.life.game.World;
import edu.fcc.cmis.life.game.Cell;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CellTable extends JTable {
    private final World world;

    public CellTable(World world, int n) {
        super(n, n);
        this.world = world;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //Get new JTable component size
                Dimension size = getSize();

                int cellSize = Math.min(size.height / n, size.width / n);

                //Check if height or width is the limiting factor and set cell size accordingly

                if (cellSize < 1) {
                    cellSize = 1;
                }

                //Set new row height to our new size
                setRowHeight(cellSize);
                setRowMargin(0);

                //Set new column width to our new size
                for (int i = 0; i < getColumnCount(); i++) {
                    getColumnModel().getColumn(i).setMaxWidth(cellSize);
                }
            }
        });
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component comp = super.prepareRenderer(renderer, row, col);
        Cell cell = world.getCell(row, col);
        comp.setBackground(CellColorPicker.colorForCell(cell));
        return comp;
    }

    public void update() {
        world.update();

        repaint();
        revalidate();
    }
}
