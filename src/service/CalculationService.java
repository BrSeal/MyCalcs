package service;

import operations.ArithmeticOperation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculationService {
    public BigDecimal calculate(BigDecimal a, BigDecimal b, ArithmeticOperation operation) {
        return switch (operation) {
            case PLUS -> a.add(b);
            case         MINUS -> a.subtract(b);
            case         MULTIPLY -> a.multiply(b);
            case         DIVIDE -> a.divide(b, RoundingMode.FLOOR);
            case         REMINDER ->  a.remainder(b);
            case         SQUARE_ROOT -> a.sqrt(MathContext.DECIMAL64);
            case         EQUAL -> a;
        };
    }

}
