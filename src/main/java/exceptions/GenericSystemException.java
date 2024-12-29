package exceptions;

public class GenericSystemException extends RuntimeException {
    public GenericSystemException(String message) {
        super(message);
    }

    public GenericSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericSystemException() {
        super("Si è verificato un errore generico");
    }
}
