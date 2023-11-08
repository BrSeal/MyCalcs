package service;

import exception.NoSuchButtonException;
import ui.BoldPanel;
import ui.ButtonListener;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
    private MainFrame frame;
    private JTextField historyTextField;
    private JTextField currentNumTextField;
    private boolean commandPressed;
    private Double numPressed;
    private double calcResult;
    private double memoryField;

    private HashMap<String, JButton> buttons = new HashMap<>();


    private Calculator() {
        initButtons();

        frame = new MainFrame("service.Calculator", buttons);
        setButtons();
        setTextField();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }

    private void setButtons() {
        BoldPanel buttonsPanel = new BoldPanel();
        buttonsPanel.setLayout(new GridLayout(6, 4, 3, 3));
        addToPanel(buttonsPanel);
        frame.add(BorderLayout.SOUTH, buttonsPanel);
    }

    private void setTextField() {

        historyTextField = new JTextField(30);
        historyTextField.setHorizontalAlignment(JTextField.RIGHT);
        historyTextField.setFont(new Font("Arial", Font.BOLD, 15));
        historyTextField.setEditable(false);

        currentNumTextField = new JTextField(30);
        currentNumTextField.setHorizontalAlignment(JTextField.RIGHT);
        currentNumTextField.setFont(new Font("Arial", Font.BOLD, 20));
        currentNumTextField.setEditable(false);
        currentNumTextField.setText("0");


        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(historyTextField);
        textPanel.add(currentNumTextField);
        currentNumTextField.requestFocus();
        frame.add(BorderLayout.CENTER, textPanel);
    }

    private void initButtons() {
        buttons.put("MR", new JButton("MR"));
        buttons.put("M+", new JButton("M+"));
        buttons.put("M-", new JButton("M-"));
        buttons.put("\b", new JButton("<-"));
        buttons.put("CE", new JButton("CE"));
        buttons.put("+-", new JButton("+-"));
        buttons.put("√", new JButton("√"));
        buttons.put("7", new JButton("7"));
        buttons.put("8", new JButton("8"));
        buttons.put("9", new JButton("9"));
        buttons.put("/", new JButton("/"));
        buttons.put("%", new JButton("%"));
        buttons.put("4", new JButton("4"));
        buttons.put("5", new JButton("5"));
        buttons.put("6", new JButton("6"));
        buttons.put("*", new JButton("*"));
        buttons.put("1", new JButton("1"));
        buttons.put("2", new JButton("2"));
        buttons.put("3", new JButton("3"));
        buttons.put("-", new JButton("-"));
        buttons.put("0", new JButton("0"));
        buttons.put(".", new JButton("."));
        buttons.put("+", new JButton("+"));
        buttons.put("=", new JButton("="));

        ButtonListener listener = new ButtonListener(this);

        for (Map.Entry<String, JButton> i : buttons.entrySet()) {
            i.getValue().addActionListener(listener);
        }
    }

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

    private void addToPanel(BoldPanel p) {
            p.add(getButton("MR"));
            p.add(getButton("M+"));
            p.add(getButton("M-"));
            p.add(getButton("CE"));
            p.add(getButton("%"));
            p.add(getButton("√"));
            p.add(getButton("\b"));
            p.add(getButton("/"));
            p.add(getButton("7"));
            p.add(getButton("8"));
            p.add(getButton("9"));
            p.add(getButton("-"));
            p.add(getButton("4"));
            p.add(getButton("5"));
            p.add(getButton("6"));
            p.add(getButton("*"));
            p.add(getButton("1"));
            p.add(getButton("2"));
            p.add(getButton("3"));
            p.add(getButton("+"));
            p.add(getButton("+-"));
            p.add(getButton("0"));
            p.add(getButton("."));
            p.add(getButton("="));
            getButton("MR").setEnabled(false);
    }

    public JButton getButton(String s) throws NoSuchButtonException {
        if (buttons.containsKey(s)) {
            return buttons.get(s);
        }
        throw new NoSuchButtonException(s);
    }

    public JTextField getHistoryTextField() {
        return historyTextField;
    }

    public void setHistoryTextField(JTextField historyTextField) {
        this.historyTextField = historyTextField;
    }

    public JTextField getCurrentNumTextField() {
        return currentNumTextField;
    }

    public void setCurrentNumTextField(JTextField currentNumTextField) {
        this.currentNumTextField = currentNumTextField;
    }

    public boolean isCommandPressed() {
        return commandPressed;
    }

    public void setCommandPressed(boolean commandPressed) {
        this.commandPressed = commandPressed;
    }

    public Double getNumPressed() {
        return numPressed;
    }

    public void setNumPressed(Double numPressed) {
        this.numPressed = numPressed;
    }

    public double getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(double calcResult) {
        this.calcResult = calcResult;
    }

    public double getMemoryField() {
        return memoryField;
    }

    public void setMemoryField(double memoryField) {
        this.memoryField = memoryField;
    }

    public HashMap<String, JButton> getButtons() {
        return buttons;
    }

    public void setButtons(HashMap<String, JButton> buttons) {
        this.buttons = buttons;
    }
    public MainFrame getFrame(){
        return frame;
    }
}
