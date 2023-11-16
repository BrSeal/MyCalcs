package ui.listeners;

import operations.ArithmeticOperation;
import service.CalculationService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticOperationButtonListener implements ActionListener {
    CalculationService calculatorService;

    public ArithmeticOperationButtonListener(CalculationService calculatorService){
        this.calculatorService = calculatorService;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArithmeticOperation code = ArithmeticOperation.valueOf(e.getActionCommand());
//        double res = calculatorService.calculate(code);
        System.out.println("ArithmeticOperation "+code.getLabel());
    }
}
