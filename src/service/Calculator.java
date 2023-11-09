package service;

public class Calculator { private double calcResult;

    private double calculate(Double number, String command) {
        switch (command) {
            case "+":
                calcResult += number;
                break;
            case "-":
                calcResult -= number;
                break;
            case "/":
                calcResult /= number;

                break;
            case "*":
                calcResult *= number;

                break;
            case "%":
                calcResult %= number;
            case "=":

        }
        return calcResult;
    }

}
