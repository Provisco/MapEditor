package org.academiadecodigo.mapedit;
//import org.academiadecodigo.simplegraphics.keyboard.


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.mapedit.Grid.PADDING;

/**
 * Created by codecadet on 26/10/16.
 */
public class Cursor {

    private Rectangle rectangle;
    private int row;
    private int col;
    //private boolean colorRed = true;


    public Cursor(int row, int col) {
        this.row = row;
        this.col = col;
        rectangle = new Rectangle(PADDING + row * Grid.cellSize, PADDING + col * Grid.cellSize, Grid.cellSize, Grid.cellSize);
        rectangle.fill();
        rectangle.setColor(Color.RED);
    }

    public void moveUp() {
        rectangle.translate(0, -Grid.cellSize);
        row--;
        rectangle.setColor(Color.RED);
    }

    public void moveDown() {
        rectangle.translate(0, Grid.cellSize);
        row++;
        rectangle.setColor(Color.MAGENTA);
    }

    public void moveLeft() {
        rectangle.translate(-Grid.cellSize, 0);
        col--;
        rectangle.setColor(Color.YELLOW);
    }

    public void moveRight() {
        rectangle.translate(Grid.cellSize, 0);
        col++;
        rectangle.setColor(Color.LIGHT_GRAY);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
/*
    public boolean isCursorColorRed() {
        return colorRed;
    }

    public void setCursorColor(){
        if(isCursorColorRed() == true) {
            rectangle.setColor(Color.GREEN);
            colorRed = false;
        }
        else{
            rectangle.setColor(Color.RED);
            colorRed = true;
        }
    }*/

}
