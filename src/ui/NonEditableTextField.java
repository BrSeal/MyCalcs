package ui;

import javax.swing.*;
import java.awt.*;

public class NonEditableTextField extends JTextField {
    public NonEditableTextField(int columns, int fontSize) {
        super(columns);

        setHorizontalAlignment(JTextField.RIGHT);
        setFont(new Font("Arial", Font.BOLD, fontSize));
        setEditable(false);
    }
}
