package exception;

/**
 * An exception thrown for incorrect size in the filter project.
 *
 * @author Shaun Howard
 */
public class IncorrectSizeException extends Exception {
    public IncorrectSizeException(String message) {
        super(message);
    }
}
