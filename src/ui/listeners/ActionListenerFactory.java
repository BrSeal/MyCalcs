package ui.listeners;

import operations.Operation;
import service.CalculationService;

import java.awt.event.ActionListener;

public class ActionListenerFactory {
    private final InputOperationButtonListener inputOperationButtonListener;
    private final MemoryOperationButtonListener memoryOperationButtonListener;
    private final ArithmeticOperationButtonListener arithmeticOperationButtonListener;

    public ActionListenerFactory(CalculationService calculatorService){
        inputOperationButtonListener = new InputOperationButtonListener(calculatorService);
        memoryOperationButtonListener = new MemoryOperationButtonListener(calculatorService);
        arithmeticOperationButtonListener = new ArithmeticOperationButtonListener(calculatorService);
    }

    public ActionListener getListener(Operation operation){
        return switch (operation.getType()){
            case INPUT -> inputOperationButtonListener;
            case MEMORY -> memoryOperationButtonListener;
            case ARITHMETIC -> arithmeticOperationButtonListener;
        };
    }
}
