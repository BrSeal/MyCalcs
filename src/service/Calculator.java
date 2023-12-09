package service;

import operations.ArithmeticOperation;
import java.math.BigDecimal;

public class Calculator {

    private BigDecimal memory = BigDecimal.ZERO;
    private BigDecimal result = BigDecimal.ZERO;

    CalculationService calculatorService;

    public BigDecimal modifyResult(BigDecimal a, ArithmeticOperation operation){
        result = calculatorService.calculate(result, a, operation);
        return result;
    }

    public BigDecimal modifyMemory(BigDecimal a, ArithmeticOperation operation){
        memory = calculatorService.calculate(memory, a, operation);
        return memory;
    }

    public BigDecimal getMemory(){
        return memory;
    }

    public BigDecimal getResult(){
        return result;
    }
}
