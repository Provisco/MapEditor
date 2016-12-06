package org.academiadecodigo.mapedit;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.IOException;

/**
 * Created by codecadet on 25/10/16.
 */
public class Grid {

    public static final int PADDING = 10;
    public static final int cellSize = 30;
    private int cols;
    private int rows;
    private Cell[][] cellMap;
    private Cursor cursor;


    public int getRow() {
        return rows;
    }

    public int getCol() {
        return cols;
    }

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cellMap = new Cell[cols][rows];

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                cellMap[col][row] = new Cell(col, row, cellSize);
            }
        }
        cursor = new Cursor(getRow() - 1, getCol() - 1);
    }

    public void drawGrid() {
        for (int col = 0; getCol() < col; col++) {
            for (int row = 0; getRow() < row; row++) {
                cellMap[col][row].getRectangle().draw();
            }
        }
    }

    public void moveInDirection(Direction direction) {

        switch (direction) {
            case UP:
                if (cursor.getRow() == 0) {
                    return;
                }
                cursor.moveUp();
                break;
            case DOWN:
                if (cursor.getRow() == rows - 1) {
                    return;
                }
                cursor.moveDown();
                break;
            case LEFT:
                if (cursor.getCol() == 0) {
                    return;
                }
                cursor.moveLeft();
                break;
            case RIGHT:
                if (cursor.getCol() == cols - 1) {
                    return;
                }
                cursor.moveRight();
                break;
            default:
                if (cursor.getRow() == 0) {
                    return;
                }
                cursor.moveUp();
        }
    }

    public void save() {
        char[] chars = new char[cols * rows + rows];
        int i = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (cellMap[row][col].isPainted()) {
                    chars[i] = '1';
                } else {
                    chars[i] = '0';
                }
                i++;
            }
            chars[i] = '\n';
            i++;
        }
        try {
            ReaderWriter.writeFile(chars, "resources/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        char[] chars = null;
        try {
            chars = ReaderWriter.readFile("resources/test.txt").toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (chars[i] == '\n') {
                    i++;
                }
                if (chars[i] == '1') {
                    cellMap[row][col].paint();
                } else {
                    cellMap[row][col].clear();
                }
                i++;
            }
        }
    }

    public void paintCellMap() {
        cellMap[cursor.getCol()][cursor.getRow()].paintCell();
    }
/*
    public void changeCursor(){
        cursor.setCursorColor();
    }*/

}



