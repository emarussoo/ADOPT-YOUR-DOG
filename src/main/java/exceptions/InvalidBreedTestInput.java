package exceptions;

public class InvalidBreedTestInput extends RuntimeException {
    public InvalidBreedTestInput(String message) {
        super(message);
    }
}
