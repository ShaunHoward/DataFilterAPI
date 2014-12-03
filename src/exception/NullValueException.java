package exception;

/**
 * A NullValueException is thrown when a value under operation is null but should
 * not be null for proper operation.
 *
 * @author Shaun Howard
 */
public class NullValueException extends Exception {

    /**
     * Constructs an EmptyListException with the specified detail message.
     *
     * @param message - the detail message which is saved for later retrieval by
     *                the Throwable.getMessage() method.
     */
    public NullValueException(String message) {
        super(message);
    }
}
