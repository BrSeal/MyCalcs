package ui;

import service.Calculator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

class MyKeyListener implements KeyListener {

    //TODO Отвязать от калькулятора
    private final Map<String, JButton> buttons;

    public MyKeyListener(Map<String, JButton> buttons) {
        this.buttons = buttons;
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        if (buttons.containsKey(c + "")) {
            buttons.get(c + "").doClick();
        }
        e.consume();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }


}
