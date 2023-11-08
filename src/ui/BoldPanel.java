package ui;

import javax.swing.*;
import java.awt.*;

public class BoldPanel extends JPanel
{
	@Override
	public Component add(Component comp)
	{
		Font arialBold=new Font("Arial",Font.BOLD,12);
		comp.setFont(arialBold);
		
		return super.add(comp);
	}
}
