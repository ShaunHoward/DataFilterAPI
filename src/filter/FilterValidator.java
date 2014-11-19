package filter;

import exception.NullValueException;

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
                throw new NullValueException("The input object: " + obj.toString() + " is null.");
            }
        }
    }
}
