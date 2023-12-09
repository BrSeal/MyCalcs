package service;

import operations.InputOperation;
import java.math.BigDecimal;

public class InputService {
    private String inputString = "";

    public BigDecimal getInput(){
        return inputString.isEmpty()? BigDecimal.ZERO : new BigDecimal(inputString);
    }

    public String getInputString(){
        return inputString;
    }

    public void handleInput(InputOperation input) {
        switch (input) {
            case NUM_0, NUM_1, NUM_2, NUM_3, NUM_4,
                    NUM_5, NUM_6, NUM_7, NUM_8, NUM_9 -> handleNumeric(input);
            case CLEAR -> clear();
            case SIGN -> handleSign();
            case BACKSPACE -> handleBackspace();
            case PERIOD -> handlePeriod();
        }
    }

    private void handleNumeric(InputOperation input) {
        inputString += input.getLabel();
    }

    public void clear() {
        inputString = "";
    }

    private void handleSign() {
        if (inputString.isEmpty()) {
            return;
        }

        if (inputString.startsWith("-")) {
            inputString = inputString.substring(1);
        } else {
            inputString = "-" + inputString;
        }
    }

    private void handleBackspace() {
        if (!inputString.isEmpty()) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }
    }

    private void handlePeriod() {
        if (inputString.isEmpty()) {
            inputString = "0";
        }

        if (!inputString.contains(".")) {
            inputString += '.';
        }
    }
}
