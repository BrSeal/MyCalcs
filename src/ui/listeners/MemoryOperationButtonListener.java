package ui.listeners;

import operations.MemoryOperation;
import service.CalculationService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryOperationButtonListener implements ActionListener {
    CalculationService calculatorService;

    public MemoryOperationButtonListener(CalculationService calculationService){
        this.calculatorService = calculationService;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MemoryOperation code = MemoryOperation.valueOf(e.getActionCommand());
//        double res = calculatorService.calculate(code);
        System.out.println("MemoryOperation "+code.getLabel());
    }
}
