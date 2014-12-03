package exception;

/**
 * An EmptyListException is thrown if an attempt is made to operate on an empty list
 * when the list must contain greater than zero elements for proper operation.
 *
 * @author Shaun Howard
 */
public class EmptyListException extends Exception {

    /**
     * Constructs an EmptyListException with the specified detail message.
     *
     * @param message - the detail message which is saved for later retrieval by
     *                the Throwable.getMessage() method.
     */
    public EmptyListException(String message) {
        super(message);
    }
}
