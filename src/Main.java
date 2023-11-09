import service.Calculator;
import ui.MainFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Frame frame = new MainFrame("service.Calculator", calculator);
        frame.setVisible(true);
    }
}
