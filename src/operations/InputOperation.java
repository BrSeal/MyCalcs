package operations;

import static java.awt.event.KeyEvent.*;

/**
 *  Input buttons list on UI
 */
public enum InputOperation implements Operation{

    CLEAR("CE",4),
    SIGN("+/-",21),
    PERIOD(".", 23, VK_PERIOD),
    BACKSPACE("<-", 7, VK_BACK_SPACE),
    NUM_1("1", 17, VK_1),
    NUM_2("2", 18, VK_2),
    NUM_3("3", 19, VK_3),
    NUM_4("4", 13, VK_4),
    NUM_5("5", 14, VK_5),
    NUM_6("6", 15, VK_6),
    NUM_7("7", 9, VK_7),
    NUM_8("8", 10, VK_8),
    NUM_9("9", 11, VK_9),
    NUM_0("0", 22, VK_0);

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

    InputOperation(String label, int uiOrder){
        this(label, uiOrder, null);
    }

    InputOperation(String label, int uiOrder, Integer keyCode){
        this.keyCode = keyCode;
        this.label = label;
        this.uiOrder = uiOrder;
    }

    @Override
    public OperationType getType(){
        return OperationType.INPUT;
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
