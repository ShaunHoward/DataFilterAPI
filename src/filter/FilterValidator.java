package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

import java.util.List;

/**
 * <p>
 * FilterValidator is a validation barrier that protects methods from bad input or operational data.
 * The FilterValidator properly handles null values, empty lists, numbers of out specified ranges, and
 * checking list sizes.
 * </p>
 * <p>
 * Operations throwExceptionWhenNull and throwExceptionWhenEmpty run in linear time or less depending on
 * the specified input objects and their validity.
 * </p>
 * <p>
 * Operations throwIncorrectSizeException and throwWhenOutOfRange run in constant time.
 * </p>
 * <p>
 * A FilterValidator properly handles null input by throwing a checked NullValueException when any
 * input specified to the throwExceptionWhenNull method is null.
 * </p>
 * <p>
 * A FilterValidator properly handles empty lists by throwing a checked EmptyListException when any
 * input lists specified to the throwExceptionWhenEmpty method are empty.
 * </p>
 * <p>
 * A FilterValidator properly handles checking list sizes by throwing a checked IncorrectSizeException when the
 * input list specified to the throwIncorrectSizeException method does not have a size equivalent to the specified
 * integer parameter of the method call.
 * </p>
 * <p>
 * A FilterValidator properly handles checking numbers out of specified ranges by throwing a checked IncorrectSizeException
 * when the specified input value is not between the specified rangeBegin and rangeEnd parameters.
 * </p>
 * <p>
 * When any exceptions are thrown, appropriate messages are used to construct the exception which describe what
 * failed during validation checks.
 * </p>
 * <p>
 * A FilterValidator is not intended for incorrect use. Since this is a barrier for bad input data, the programmer
 * must properly call the methods in FilterValidator with correct parameters that are sensible. If improper method
 * calls happen, the method will not operate as expected and unchecked exceptions may be thrown.
 * </p>
 *
 * @author Shaun Howard
 */
public class FilterValidator {

    /**
     * Throws an exception when any of the input objects are null.
     *
     * @param objs - the object(s) that may be null
     * @throws exception.NullValueException - if any of the input
     * objects are null
     */
    public static void throwExceptionWhenNull(Object... objs) throws NullValueException {
        for (Object obj : objs) {
            if (obj == null) {
                throw new NullValueException("An object is null.");
            }
        }
    }

    /**
     * Throws an exception when any of the input lists are empty.
     *
     * @param lists - the lists to check if empty
     * @throws exception.EmptyListException - if an input list is empty
     */
    public static void throwExceptionWhenEmpty(List... lists) throws EmptyListException {
        for (List list : lists){
            if (list.isEmpty()){
                throw new EmptyListException("The list: " + list.toString() + " is empty.");
            }
        }
    }

    /**
     * Throws an exception when the size of the input list does not match the input size.
     *
     * @param list - the list to check the size of
     * @param size - the size that the list should be
     * @throws IncorrectSizeException - if the size of the list does not equal size
     */
    public static void throwIncorrectSizeException(List list, int size) throws IncorrectSizeException {
        if (list.size() != size) {
            throw new IncorrectSizeException("The list: " + list.toString() +
                    " does not have " + size + " elements.");
        }
    }

    /**
     * Throws an exception when the given value does not lie within the given range.
     *
     * @param value - the value to range check
     * @param rangeBegin - the beginning of the range
     * @param rangeEnd - the end of the range
     * @throws IncorrectSizeException - if value is not in the given range
     */
    public static void throwWhenOutOfRange(int value, int rangeBegin, int rangeEnd)
            throws IncorrectSizeException {
        if (!(rangeBegin <= value && value <= rangeEnd)) {
            throw new IncorrectSizeException("The value: " + value + " is not within the range: "
                    + rangeBegin + " to " + rangeEnd);
        }
    }
}
