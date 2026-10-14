package ExceptionCS;

public class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}