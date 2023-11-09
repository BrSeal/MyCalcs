package ui;

import service.ButtonCode;
import service.Calculator;
import ui.listeners.ButtonListener;
import ui.listeners.MyKeyListener;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class MainFrame extends JFrame {

    public MainFrame(String name, Calculator calculator) {
        super(name);

        MyKeyListener keyListener = new MyKeyListener();

        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(keyListener);
        setFocusable(true);

        add(BorderLayout.CENTER, createTextPanel());
        add(BorderLayout.SOUTH, createButtonsPanel(keyListener, calculator));
    }

    private JPanel createTextPanel(){
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

    private JPanel createButtonsPanel(MyKeyListener keyListener, Calculator calculator){
        ButtonListener buttonListener = new ButtonListener(calculator);

        JPanel buttonsPanel = new BoldPanel();
        buttonsPanel.setLayout(new GridLayout(6, 4, 3, 3));

        Arrays.stream(ButtonCode.values())
                .sorted(Comparator.comparingInt(b -> b.uiOrder))
                .forEach(buttonCode -> {
                    JButton button = new JButton(buttonCode.label);
                    button.addActionListener(buttonListener);
                    button.setActionCommand(buttonCode.name());

                    buttonsPanel.add(button);

                    if(buttonCode.keyCode != null){
                        keyListener.addButton(buttonCode.keyCode, button);
                    }
                });

        return buttonsPanel;
    }
}
