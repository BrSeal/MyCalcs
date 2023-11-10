package operations;

import static java.awt.event.KeyEvent.*;

/**
 *  Buttons list on UI
 */
public enum ArithmeticOperation implements Operation{
    PLUS("+", 20, VK_PLUS),
    MINUS("-", 12, VK_MINUS),
    MULTIPLY("*", 16, VK_ASTERISK),
    DIVIDE("/", 8, VK_SLASH),
    REMINDER("%",5),
    SQUARE_ROOT("√",6),
    EQUAL("=", 24, VK_EQUALS);

    /**
     * Button label
     */
    private final String label;

    /**
     *  Needed to properly place buttons on ui
     */
    private final int uiOrder;

    /**
     *  binds button to keyboard
     */
    private final Integer keyCode;

    ArithmeticOperation(String label, int uiOrder){
        this(label, uiOrder, null);
    }

    ArithmeticOperation(String label, int uiOrder, Integer keyCode){
        this.keyCode = keyCode;
        this.label = label;
        this.uiOrder = uiOrder;
    }

    @Override
    public OperationType getType(){
        return OperationType.ARITHMETIC;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getUiOrder() {
        return uiOrder;
    }

    @Override
    public Integer getKeyCode() {
        return keyCode;
    }
}
