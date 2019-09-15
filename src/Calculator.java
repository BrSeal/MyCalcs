import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Calculator
{
	JFrame frame;
	JTextField historyText;
	JTextField currentNumText;
	
	double calcResult;
	double memoryField;
	
	
	MyKeyListener myKeyListener;
	ButtonListener listener;
	
	HashMap<String, JButton> buttons = new HashMap<>();
	
	
	public Calculator()
	{
		frame = new JFrame("Calculator");
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		setButtons();
		
		setTextField();
		
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		Calculator c = new Calculator();
	}
	
	private void setButtons()
	{
		initButtons();
		
		
		BoldPanel buttonsPanel = new BoldPanel();
		buttonsPanel.setLayout(new GridLayout(6, 5, 3, 3));
		
		addToPanel(buttonsPanel);
		frame.add(BorderLayout.SOUTH, buttonsPanel);
		
		
	}
	
	private void setTextField()
	{
		
		historyText = new JTextField(30);
		historyText.setHorizontalAlignment(JTextField.RIGHT);
		historyText.setFont(new Font("Arial", Font.BOLD, 20));
		historyText.setEditable(false);
		
		currentNumText = new JTextField(30);
		currentNumText.setHorizontalAlignment(JTextField.RIGHT);
		currentNumText.setFont(new Font("Arial", Font.BOLD, 35));
		currentNumText.setEditable(false);
		currentNumText.setText("0");
		
		myKeyListener = this.new MyKeyListener();
		
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2, 1));
		textPanel.add(historyText);
		textPanel.add(currentNumText);
		currentNumText.requestFocus();
		frame.add(BorderLayout.CENTER, textPanel);
	}
	
	void initButtons()
	{
		buttons.put("MC", new JButton("MC"));
		buttons.put("MR", new JButton("MR"));
		buttons.put("MS", new JButton("MS"));
		buttons.put("M+", new JButton("M+"));
		buttons.put("M-", new JButton("M-"));
		buttons.put("\b", new JButton("<-"));
		buttons.put("CE", new JButton("CE"));
		buttons.put("C", new JButton("C"));
		buttons.put("+-", new JButton("+-"));
		buttons.put("sqr", new JButton("sqr"));
		buttons.put("7", new JButton("7"));
		buttons.put("8", new JButton("8"));
		buttons.put("9", new JButton("9"));
		buttons.put("/", new JButton("/"));
		buttons.put("%", new JButton("%"));
		buttons.put("4", new JButton("4"));
		buttons.put("5", new JButton("5"));
		buttons.put("6", new JButton("6"));
		buttons.put("*", new JButton("*"));
		buttons.put("1/x", new JButton("1/x"));
		buttons.put("1", new JButton("1"));
		buttons.put("2", new JButton("2"));
		buttons.put("3", new JButton("3"));
		buttons.put("-", new JButton("-"));
		buttons.put("0", new JButton("0"));
		buttons.put(",", new JButton("."));
		buttons.put("+", new JButton("+"));
		buttons.put("=", new JButton("="));
		
		listener = new ButtonListener();
		for (Map.Entry<String, JButton> i : buttons.entrySet())
		{
			i.getValue().addActionListener(listener);
		}
	}
	
	private void addToPanel(BoldPanel p)
	{
		try
		{
			p.add(getButton("MC"));
			p.add(getButton("MR"));
			p.add(getButton("MS"));
			p.add(getButton("M+"));
			p.add(getButton("M-"));
			p.add(getButton("\b"));
			p.add(getButton("CE"));
			p.add(getButton("C"));
			p.add(getButton("+-"));
			p.add(getButton("sqr"));
			p.add(getButton("7"));
			p.add(getButton("8"));
			p.add(getButton("9"));
			p.add(getButton("/"));
			p.add(getButton("%"));
			p.add(getButton("4"));
			p.add(getButton("5"));
			p.add(getButton("6"));
			p.add(getButton("*"));
			p.add(getButton("1/x"));
			p.add(getButton("1"));
			p.add(getButton("2"));
			p.add(getButton("3"));
			p.add(getButton("-"));
			p.add(getButton("0"));
			p.add(getButton(","));
			p.add(getButton("+"));
			p.add(getButton("="));
		}catch (NoSuchButtonException e)
		{
			System.out.println(e.errMessage);
			e.printStackTrace();
		}
	}
	
	private JButton getButton(String s) throws NoSuchButtonException
	{
		if (buttons.containsKey(s))
		{
			return buttons.get(s);
		}
		throw new NoSuchButtonException(s);
	}
	
	private class MyKeyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{
			char c = e.getKeyChar();
			
			if (buttons.containsKey(c + ""))
			{
				getButton(c + "").doClick();
				
			}
			e.consume();
		}
		
		public void keyPressed(KeyEvent e)
		{
		}
		
		public void keyReleased(KeyEvent e)
		{
		}
		
		
	}
	
	// допилить реакцию на кнопки
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			String numText = currentNumText.getText();
			switch (command)
			{
				case "MC":
					
					break;
				case "MR":
					
					break;
				case "MS":
					
					break;
				case "M+":
					
					break;
				case "M-":
					
					break;
				
				
				case "<-":
					if (numText.startsWith("-")) {
						if (numText.length() == 2)
						{
							currentNumText.setText("0");
							break;
						}
					}else {
						if (numText.length() == 1)
						{
							currentNumText.setText("0");
							break;
						}
					}
					currentNumText.setText(numText.substring(0, numText.length() - 1));
					break;
				case "C":
					historyText.setText("");
				case "CE":
					currentNumText.setText("0");
					break;
					
				case "+-":
					if (!numText.equals("0")) {
						if (numText.startsWith("-"))
						{
							currentNumText.setText(numText.substring(1));
						}
						else
						{
							currentNumText.setText("-" + numText);
						}
					}
					break;
					
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
					if (numText.length() < 16) {
						if (numText.equals("0"))
						{
							currentNumText.setText(command);
						}
						else
						{
							currentNumText.setText(numText + command);
						}
					}
					break;
					
				case ".":
					if (numText.length() < 16 && !numText.contains(".")) {
						currentNumText.setText(numText + command);
					}
					break;
					
				//реализовать логику вычисления
				case "-":
					if(historyText.getText().length()==0)
						calcResult=Double.parseDouble(numText);
					else calcResult-=Double.parseDouble(numText);
					
					currentNumText.setText(calcResult+"");
				case "*":
				case "sqr":
				case "/":
				case "%":
				case "+":
				case "1/x":
					historyText.setText(historyText.getText()+numText+command);
					
					
					break;
					
					//реализовать нажатие на кнопку =
				case "=":
					
					break;
			}
			
		}
	}
}