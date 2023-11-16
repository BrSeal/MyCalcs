package ui.listeners;

import operations.InputOperation;
import service.CalculationService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputOperationButtonListener implements ActionListener {
    CalculationService calculatorService;

    public InputOperationButtonListener(CalculationService calculatorService){
        this.calculatorService = calculatorService;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        InputOperation code = InputOperation.valueOf(e.getActionCommand());
//        double res = calculatorService.calculate(code);
        System.out.println("InputOperation "+code.getLabel());
    }
}
