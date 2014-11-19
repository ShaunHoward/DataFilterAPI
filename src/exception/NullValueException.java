package exception;

/**
 * An exception thrown for null values in the filter project.
 *
 * @author Shaun Howard
 */
public class NullValueException extends Exception {
    public NullValueException(String message) {
        super(message);
    }
}
