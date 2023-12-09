import service.CalculationService;
import service.Calculator;
import service.InputService;
import ui.MainFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        CalculationService calculatorService = new CalculationService();
        Calculator calculator = new Calculator();
        InputService inputService = new InputService();
        Frame frame = new MainFrame("service.Calculator", calculatorService, calculator, inputService);
        frame.setVisible(true);
    }
}
