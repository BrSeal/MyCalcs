package ui;

import service.ButtonCode;
import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(ButtonCode.valueOf(command));
    }
}
