package operations;

public interface Operation {
    OperationType getType();

    String getLabel();
    int getUiOrder();
    Integer getKeyCode();

    enum OperationType{
        MEMORY,
        ARITHMETIC,
        INPUT
    }
}
