package ui.listeners;

import operations.InputOperation;
import service.InputService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputOperationButtonListener implements ActionListener {
    InputService service;

    public InputOperationButtonListener(InputService service){
        this.service = service;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        InputOperation input = InputOperation.valueOf(e.getActionCommand());

        service.handleInput(input);
        System.out.printf("Current input: %s, inputString:%s, value:%s\n\r", input.getLabel(), service.getInputString(), service.getInput());
    }
}
