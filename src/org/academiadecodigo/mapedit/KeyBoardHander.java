package org.academiadecodigo.mapedit;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.KeyEvent;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

/**
 * Created by codecadet on 26/10/16.
 */
public class KeyBoardHander implements KeyboardHandler {

    private Grid grid;


    public KeyBoardHander(Grid grid) {
        this.grid = grid;

    }

    public void start() {
        Keyboard k = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent paintBlue = new KeyboardEvent();
        KeyboardEvent paintPink = new KeyboardEvent();
        KeyboardEvent save = new KeyboardEvent();
        KeyboardEvent load = new KeyboardEvent();
        KeyboardEvent cursorColor = new KeyboardEvent();

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        paintBlue.setKey(KeyboardEvent.KEY_U);
        paintPink.setKey(KeyboardEvent.KEY_I);
        save.setKey(KeyboardEvent.KEY_S);
        load.setKey(KeyboardEvent.KEY_L);
        cursorColor.setKey(KeyboardEvent.KEY_C);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintBlue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintPink.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        cursorColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(up);
        k.addEventListener(down);
        k.addEventListener(left);
        k.addEventListener(right);
        k.addEventListener(paintBlue);
        k.addEventListener(paintPink);
        k.addEventListener(save);
        k.addEventListener(load);
        k.addEventListener(cursorColor);
    }

    @Override
    public void keyPressed(KeyboardEvent jogo) {
        switch (jogo.getKey()) {
            case KeyboardEvent.KEY_UP:
                grid.moveInDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                grid.moveInDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                grid.moveInDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                grid.moveInDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_U:
                grid.paintCellMap();
                break;
            /*case KeyboardEvent.KEY_I:
                grid.paintCellMap();
                break;*/
            case KeyboardEvent.KEY_S:
                grid.save();
                break;
            case KeyboardEvent.KEY_L:
                grid.load();
                break;
            /*case KeyboardEvent.KEY_C:
                grid.changeCursor();
                break;*/
            default:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
