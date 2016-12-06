package org.academiadecodigo.mapedit;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

import static sun.jvm.hotspot.oops.MethodData.cellSize;

/**
 * Created by codecadet on 25/10/16.
 */
public class Main {

    public static void main(String[] args) {


        char[] chars = {'a', 'b', 'c', 'd', 'e'};

        ReaderWriter readWrite = new ReaderWriter();

        try {
            System.out.println(readWrite.readFile("resources/test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Grid grid1 = new Grid(20, 20);
        grid1.drawGrid();


        KeyBoardHander k = new KeyBoardHander(grid1);
        k.start();

    }
}
