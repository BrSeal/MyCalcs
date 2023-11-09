package service;

import static java.awt.event.KeyEvent.*;

/**
 *  Buttons list on UI
 */
public enum ButtonCode {
    //memory
    MEMORY_LOAD("MR",1),
    MEMORY_PLUS("M+",2),
    MEMORY_MINUS("M-",3),

    //input
    CLEAR("CE",4),
    SIGN("+-",21),
    PERIOD(".", 23, VK_PERIOD),
    BACKSPACE("<-", 7, VK_BACK_SPACE),

    //arithmetics
    PLUS("+", 20, VK_PLUS),
    MINUS("-", 12, VK_MINUS),
    MULTIPLY("*", 16, VK_ASTERISK),
    DIVIDE("/", 8, VK_SLASH),
    REMINDER("%",5),
    SQUARE_ROOT("√",6),
    EQUAL("=", 24, VK_EQUALS),

    //numbers
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
     *  binds button to keyboard
     */
    public final Integer keyCode;

    /**
     * Button label
     */
    public final String label;

    /**
     *  Needed to properly place buttons on ui
     */
    public final int uiOrder;


    ButtonCode(String text, int uiOrder){
        this(text, uiOrder, null);
    }

    ButtonCode(String text, int uiOrder, Integer keyCode){
        this.keyCode = keyCode;
        this.label = text;
        this.uiOrder = uiOrder;
    }


}
