package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

import java.util.List;

/**
 * Validation barrier for the filter project.
 *
 * @author Shaun Howard
 */
public class FilterValidator {

    /**
     * Throws an exception when any of the input objects are null.
     *
     * @param objs - the object(s) that may be null
     * @throws exception.NullValueException - thrown when any of the input
     * objects are null
     */
    public static void throwExceptionWhenNull(Object... objs) throws NullValueException {
        for (Object obj : objs){
            if (obj == null){
                throw new NullValueException("The object: " + obj.toString() + " is null.");
            }
        }
    }

    /**
     * Throws an exception when any of the input lists are empty.
     *
     * @param lists - the lists to check if empty
     * @throws exception.EmptyListException - thrown when an input list is empty
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
     * @throws IncorrectSizeException - thrown when the size of the list does not equal size
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
     * @throws IncorrectSizeException - thrown when value is not in the given range
     */
    public static void throwWhenOutOfRange(int value, int rangeBegin, int rangeEnd)
            throws IncorrectSizeException {
        if (!(rangeBegin <= value && value <= rangeEnd)) {
            throw new IncorrectSizeException("The value: " + value + " is not within the range: "
                    + rangeBegin + " to " + rangeEnd);
        }
    }
}
