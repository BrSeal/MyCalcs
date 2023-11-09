package ui.listeners;

import service.ButtonCode;
import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    Calculator calculator;

    public ButtonListener(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonCode buttonCode = ButtonCode.valueOf(e.getActionCommand());
        double res = calculator.calculate(123.0, buttonCode);
        System.out.println(buttonCode.label+" "+res);
    }
}
