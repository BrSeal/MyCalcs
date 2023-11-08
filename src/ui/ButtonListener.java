package ui;

import service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final Calculator calculator;

    public ButtonListener(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String currentNumText = calculator.getCurrentNumTextField().getText();
        switch (command) {

            case "MR":
                if (calculator.getMemoryField() == Double.parseDouble(currentNumText)) {
                    calculator.setMemoryField(0);
                    calculator.getButtons().get("MR").setEnabled(false);
                } else {
                    String tempString = calculator.getMemoryField() + "";
                    if (tempString.endsWith(".0")) {
                        calculator.getCurrentNumTextField().setText(
                                tempString.substring(0, tempString.length() - 2));
                    } else {
                        calculator.getCurrentNumTextField().setText(calculator.getMemoryField() + "");
                        calculator.setMemoryField(Double.parseDouble(tempString));
                    }
                }
                break;
            case "M+":
                calculator.setMemoryField(calculator.getMemoryField() + Double.parseDouble(currentNumText));
                if (!calculator.getButtons().get("MR").isEnabled()) calculator.getButtons().get("MR").setEnabled(true);
                break;
            case "M-":
                calculator.setMemoryField(calculator.getMemoryField() - Double.parseDouble(currentNumText));
                if (!calculator.getButtons().get("MR").isEnabled()) calculator.getButtons().get("MR").setEnabled(true);
                break;

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

            case "<-":
                if (currentNumText.startsWith("-")) {
                    if (currentNumText.length() == 2) {
                        calculator.getCurrentNumTextField().setText("0");
                        break;
                    }
                } else {
                    if (currentNumText.length() == 1) {
                        calculator.getCurrentNumTextField().setText("0");
                        break;
                    }
                }
                calculator.getCurrentNumTextField().setText(currentNumText.substring(0, currentNumText.length() - 1));
                break;
            case "CE":
                if (currentNumText.equals("0")) {
                    calculator.getHistoryTextField().setText("");
                    calculator.setMemoryField(0);
                    calculator.setCalcResult(0);
                    calculator.getButtons().get("MR").setEnabled(false);

                }
                calculator.getCurrentNumTextField().setText("0");

                break;

            case "+-":
                if (!currentNumText.equals("0")) {
                    if (currentNumText.startsWith("-")) {
                        calculator.getCurrentNumTextField().setText(currentNumText.substring(1));
                    } else {
                        calculator.getCurrentNumTextField().setText("-" + currentNumText);
                    }
                }
                break;

//////// NUMBERS ////////

            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":

                if (calculator.isCommandPressed()) {
                    currentNumText = "0";
                }
                if (currentNumText.length() < 16) {
                    if (currentNumText.equals("0")) {
                        calculator.getCurrentNumTextField().setText(command);
                    } else {
                        calculator.getCurrentNumTextField().setText(currentNumText + command);
                    }
                }
                calculator.setCommandPressed(false);
                break;

            case ".":
                if (calculator.isCommandPressed()) {

                    currentNumText = "0";
                }
                if (currentNumText.length() < 16 && !currentNumText.contains(".")) {
                    calculator.getCurrentNumTextField().setText(currentNumText + command);
                }
                calculator.setCommandPressed(false);
                break;

            default:
                if (calculator.getNumPressed() == null) {
                    calculator.setNumPressed(Double.parseDouble(currentNumText));
                }
        }
        calculator.getFrame().requestFocus();
    }


}
