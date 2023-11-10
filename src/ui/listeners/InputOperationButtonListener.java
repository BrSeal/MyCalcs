package ui.listeners;

import operations.InputOperation;
import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputOperationButtonListener implements ActionListener {
    Calculator calculator;

    public InputOperationButtonListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        InputOperation code = InputOperation.valueOf(e.getActionCommand());
//        double res = calculator.calculate(code);
        System.out.println("InputOperation "+code.getLabel());
    }
}
