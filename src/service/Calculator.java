package service;

public class Calculator { private double calcResult;

    public double calculate(Double number, ButtonCode code) {
        switch (code) {
            case PLUS:
                calcResult += number;
                break;
            case MINUS:
                calcResult -= number;
                break;
            case DIVIDE:
                calcResult /= number;
                break;
            case MULTIPLY:
                calcResult *= number;
                break;
            case REMINDER:
                calcResult %= number;
            case SQUARE_ROOT:
                break;
            case SIGN:
                break;
            case EQUAL:
                break;
        }
        return calcResult;
    }

}
