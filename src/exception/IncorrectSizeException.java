package exception;

/**
 * An IncorrectSizeException is thrown if an attempt is made to operate on a number
 * that lies outside of a desired range of numbers.
 *
 * @author Shaun Howard
 */
public class IncorrectSizeException extends Exception {

    /**
     * Constructs an IncorrectSizeException with the specified detail message.
     *
     * @param message - the detail message which is saved for later retrieval by
     *                the Throwable.getMessage() method.
     */
    public IncorrectSizeException(String message) {
        super(message);
    }
}
