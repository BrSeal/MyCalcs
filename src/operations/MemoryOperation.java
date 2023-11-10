package operations;

/**
 *  Memory buttons list on UI
 */
public enum MemoryOperation implements Operation{
    //memory
    MEMORY_LOAD("MR",1),
    MEMORY_PLUS("M+",2),
    MEMORY_MINUS("M-",3);

    /**
     * Button label
     */
    private final String label;

    /**
     *  Needed to properly place buttons on ui
     */
    private final int uiOrder;

    MemoryOperation(String label, int uiOrder){
        this.label = label;
        this.uiOrder = uiOrder;
    }

    @Override
    public OperationType getType(){
        return OperationType.MEMORY;
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
        return null;
    }
}
