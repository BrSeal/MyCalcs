package ui;

import operations.ArithmeticOperation;
import operations.InputOperation;
import operations.MemoryOperation;
import service.CalculationService;
import ui.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Stream;

public class MainFrame extends JFrame {

    private final CalculationService calculationService;
    private final MyKeyListener keyListener = new MyKeyListener();

    public MainFrame(String name, CalculationService calculationService) {
        super(name);
        this.calculationService = calculationService;
        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(keyListener);
        setFocusable(true);

        add(BorderLayout.CENTER, createTextPanel());
        add(BorderLayout.SOUTH, createButtonsPanel());
    }

    private JPanel createTextPanel() {
        JPanel textPanel = new JPanel();
        NonEditableTextField historyTextField = new NonEditableTextField(30, 15);
        NonEditableTextField currentNumTextField = new NonEditableTextField(30, 20);
        currentNumTextField.setText("0");

        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(historyTextField);
        textPanel.add(currentNumTextField);
        currentNumTextField.requestFocus();
        return textPanel;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new BoldPanel();
        buttonsPanel.setLayout(new GridLayout(6, 4, 3, 3));

        createButtonsWithOrder().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .forEach(buttonsPanel::add);

        return buttonsPanel;
    }

    private Map<Integer, JButton> createButtonsWithOrder() {
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory(calculationService);
        return Stream.of(
                        InputOperation.values(),
                        ArithmeticOperation.values(),
                        MemoryOperation.values()
                )
                .flatMap(Arrays::stream)
                .reduce(new HashMap<>(),
                        (map, operation) -> {
                            JButton button = new JButton(operation.getLabel());
                            button.setActionCommand(operation.name());
                            button.addActionListener(actionListenerFactory.getListener(operation));

                            if(operation.getKeyCode() != null) {
                                keyListener.addButton(operation.getKeyCode(), button);
                            }
                            map.put(operation.getUiOrder(), button);
                            return map;
                        },
                        (m, m2) -> {
                            m.putAll(m2);
                            return m;
                        }
                );
    }
}
