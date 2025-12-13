package exceptions;

public class EmptySearchArgumentException extends IllegalArgumentException {
    public EmptySearchArgumentException(String msg) {
        super(msg);
    }
}
