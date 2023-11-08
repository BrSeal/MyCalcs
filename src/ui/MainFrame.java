package ui;

import javax.swing.*;
import java.util.Map;

public class MainFrame extends JFrame {
    public MainFrame(String name, Map<String, JButton> buttons) {
        super(name);

        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new MyKeyListener(buttons));
        setFocusable(true);

    }
}
