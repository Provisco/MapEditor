package org.academiadecodigo.mapedit;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.mapedit.Grid.PADDING;

/**
 * Created by codecadet on 25/10/16.
 */
public class Cell {

    private int col;
    private int row;
    private Rectangle rectangle;
    private boolean painted;

    public Cell(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;
        rectangle = new Rectangle(PADDING + col * cellSize, PADDING + row * cellSize, cellSize, cellSize);
        rectangle.draw();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isPainted() {
        return painted;
    }

    public void paint() {
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        painted = true;
    }

    public void clear() {
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
        painted = false;
    }

    //Used to paint cells with the cursor.
    public void paintCell() {
        //When the cell is not painted it will fill it blue
        if (!isPainted()) {
            rectangle.setColor(Color.BLUE);
            rectangle.fill();
            painted = true;
        }
        //When it is painted, it will draw the outlines black again
        else {
            rectangle.setColor(Color.BLACK);
            rectangle.draw();
            painted = false;
        }
    }
}
