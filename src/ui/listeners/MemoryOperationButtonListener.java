package ui.listeners;

import operations.MemoryOperation;
import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryOperationButtonListener implements ActionListener {
    Calculator calculator;

    public MemoryOperationButtonListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MemoryOperation code = MemoryOperation.valueOf(e.getActionCommand());
//        double res = calculator.calculate(code);
        System.out.println("MemoryOperation "+code.getLabel());
    }
}
