package modelle.exceptions;

public class InventoryFullException extends Exception {
    public InventoryFullException() {
        super();
    }

    public InventoryFullException(String s) {
        super(s);
    }
}
