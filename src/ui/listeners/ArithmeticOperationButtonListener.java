package ui.listeners;

import operations.ArithmeticOperation;
import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticOperationButtonListener implements ActionListener {
    Calculator calculator;

    public ArithmeticOperationButtonListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArithmeticOperation code = ArithmeticOperation.valueOf(e.getActionCommand());
//        double res = calculator.calculate(code);
        System.out.println("ArithmeticOperation "+code.getLabel());
    }
}
