package ui.listeners;

import operations.Operation;
import service.Calculator;

import java.awt.event.ActionListener;

public class ActionListenerFactory {
    private final InputOperationButtonListener inputOperationButtonListener;
    private final MemoryOperationButtonListener memoryOperationButtonListener;
    private final ArithmeticOperationButtonListener arithmeticOperationButtonListener;

    public ActionListenerFactory(Calculator calculator){
        inputOperationButtonListener = new InputOperationButtonListener(calculator);
        memoryOperationButtonListener = new MemoryOperationButtonListener(calculator);
        arithmeticOperationButtonListener = new ArithmeticOperationButtonListener(calculator);
    }

    public ActionListener getListener(Operation operation){
        return switch (operation.getType()){
            case INPUT -> inputOperationButtonListener;
            case MEMORY -> memoryOperationButtonListener;
            case ARITHMETIC -> arithmeticOperationButtonListener;
        };
    }
}
