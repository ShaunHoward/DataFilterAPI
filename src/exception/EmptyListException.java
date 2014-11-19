package exception;

/**
 * An exception thrown for empty lists in the filter project.
 *
 * @author Shaun Howard
 */
public class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}
