import service.CalculationService;
import ui.MainFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        CalculationService calculatorService = new CalculationService();
        Frame frame = new MainFrame("service.Calculator", calculatorService);
        frame.setVisible(true);
    }
}
