package ui.listeners;

import operations.Operation;
import service.CalculationService;
import service.Calculator;
import service.InputService;

import java.awt.event.ActionListener;

public class ActionListenerFactory {
    private final InputOperationButtonListener inputOperationButtonListener;
    private final MemoryOperationButtonListener memoryOperationButtonListener;
    private final ArithmeticOperationButtonListener arithmeticOperationButtonListener;

    public ActionListenerFactory(CalculationService calculationService, Calculator calculator, InputService inputService){
        inputOperationButtonListener = new InputOperationButtonListener(inputService);
        memoryOperationButtonListener = new MemoryOperationButtonListener(calculator);
        arithmeticOperationButtonListener = new ArithmeticOperationButtonListener(calculationService);
    }

    public ActionListener getListener(Operation operation){
        return switch (operation.getType()){
            case INPUT -> inputOperationButtonListener;
            case MEMORY -> memoryOperationButtonListener;
            case ARITHMETIC -> arithmeticOperationButtonListener;
        };
    }
}
