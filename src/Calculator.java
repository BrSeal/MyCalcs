import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
	private JFrame frame;
	private JTextField historyTextField;
	private JTextField currentNumTextField;
	private boolean commandPressed;
	private Double numPressed;
	private double calcResult;
	private double memoryField;
	
	private HashMap<String, JButton> buttons = new HashMap<>();
	
	
	private Calculator() {
		frame = new JFrame("Calculator");
		frame.setSize(250, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(this.new MyKeyListener());
		frame.setFocusable(true);
		setButtons();
		
		setTextField();
		
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	private void setButtons() {
		initButtons();
		
		
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
		
		ButtonListener listener = new ButtonListener();
		
		for (Map.Entry<String, JButton> i : buttons.entrySet()) {
			i.getValue().addActionListener(listener);
		}
	}
	
	private double calculate(Double number,String command) {
		
		
		switch (command){
			case "+":
				calcResult+=number;
				break;
			case "-":
				calcResult-=number;
				break;
			case "/":
				calcResult/=number;
				
				break;
			case "*":
				calcResult*=number;
				
				break;
			case "%":
				calcResult%=number;
			case "=":
			
		}
		return calcResult;
	}
	
	private void addToPanel(BoldPanel p) {
		try {
			
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
			
		} catch (NoSuchButtonException e) {
			System.out.println(e.errMessage);
			e.printStackTrace();
		}
	}
	
	private JButton getButton(String s) throws NoSuchButtonException {
		if (buttons.containsKey(s)) {
			return buttons.get(s);
		}
		throw new NoSuchButtonException(s);
	}
	
	private class MyKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			
			if (buttons.containsKey(c + "")) {
				getButton(c + "").doClick();
				
			}
			e.consume();
		}
		
		public void keyPressed(KeyEvent e) {
		}
		
		public void keyReleased(KeyEvent e) {
		}
		
		
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			String currentNumText = currentNumTextField.getText();
			switch (command) {
				
				case "MR":
					if (memoryField == Double.parseDouble(currentNumText)) {
						memoryField = 0;
						buttons.get("MR").setEnabled(false);
					} else {
						String tempString = memoryField + "";
						if (tempString.endsWith(".0")) {
							currentNumTextField.setText(
									tempString.substring(0, tempString.length() - 2));
						} else {
							currentNumTextField.setText(memoryField + "");
							memoryField = Double.parseDouble(tempString);
						}
					}
					break;
				case "M+":
					memoryField += Double.parseDouble(currentNumText);
					if (!buttons.get("MR").isEnabled()) buttons.get("MR").setEnabled(true);
					break;
				case "M-":
					memoryField -= Double.parseDouble(currentNumText);
					if (!buttons.get("MR").isEnabled()) buttons.get("MR").setEnabled(true);
					break;

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
				
				case "<-":
					if (currentNumText.startsWith("-")) {
						if (currentNumText.length() == 2) {
							currentNumTextField.setText("0");
							break;
						}
					} else {
						if (currentNumText.length() == 1) {
							currentNumTextField.setText("0");
							break;
						}
					}
					currentNumTextField.setText(currentNumText.substring(0, currentNumText.length() - 1));
					break;
				case "CE":
					if (currentNumText.equals("0")) {
						historyTextField.setText("");
						memoryField = 0;
						calcResult=0;
						buttons.get("MR").setEnabled(false);
						
					}
					currentNumTextField.setText("0");
					
					break;
				
				case "+-":
					if (!currentNumText.equals("0")) {
						if (currentNumText.startsWith("-")) {
							currentNumTextField.setText(currentNumText.substring(1));
						} else {
							currentNumTextField.setText("-" + currentNumText);
						}
					}
					break;

//////// NUMBERS ////////
				
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "0":
					
					if (commandPressed) {
						currentNumText="0";
					}
					if (currentNumText.length() < 16) {
						if (currentNumText.equals("0")) {
							currentNumTextField.setText(command);
						} else {
							currentNumTextField.setText(currentNumText + command);
						}
					}
					commandPressed = false;
					break;
				
				case ".":
					if (commandPressed) {
						
						currentNumText="0";
					}
					if (currentNumText.length() < 16 && !currentNumText.contains(".")) {
						currentNumTextField.setText(currentNumText + command);
					}
					commandPressed = false;
					break;

/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				default:
					if(numPressed==null) numPressed=Double.parseDouble(currentNumText);
					else {
//????
					}
			}
			
			frame.requestFocus();
			
		}
		
		
	}
}