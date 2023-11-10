package ui.listeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//TODO не работает
public class MyKeyListener implements KeyListener {
    private final Map<Integer, JButton> buttons = new HashMap<>();

    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped "+e.getKeyCode());
        Optional.of(e.getKeyCode())
                .map(buttons::get)
                .ifPresent(JButton::doClick);
    }

    public void addButton(int keyCode, JButton button){
        buttons.put(keyCode, button);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("key keyPressed "+e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("key keyReleased "+e.getKeyCode());
    }
}
