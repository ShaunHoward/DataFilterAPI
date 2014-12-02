package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * <p>
 * A filter designed to produce a distinctly filtered generic output value.
 * The output value depends on the type of filter implemented by the user.
 * The user of this interface has precise control over when and what value is filtered.
 * A single element can only be accessed after filtering. Typically, previously filtered elements are
 * not accessible to the user; however, depending on implementation, the user may be able to access a previously
 * filtered value.
 * </p>
 * <p>
 * The Filter interface provides one method to filter a specified, comparable value. From a performance
 * standpoint, the method will perform within a maximum of linear time operation depending on the implementation.
 * The value returned by the filter method will have the precision of the cast from type A to type B. A loss of
 * precision is possible when casting from a wider type to narrower type.
 * </p>
 * <p>
 * All filter implementations have restrictions on the elements they may filter. For example,
 * all implementations prohibit null elements and some have restrictions on the types of their elements.
 * Attempting to add an ineligible element throws either an unchecked NullValueException or a checked
 * ClassCastException. When a ClassCastException is checked, the filter will print a
 * message to the standard error output as well as produce a null value.
 * </p>
 * <p>
 * Unchecked EmptyListException and IncorrectSizeExceptions are thrown when the implementation utilizes
 * a validation from the FilterValidator class. The earlier exception is thrown when the list operated on
 * contains zero elements but should contain at least one element for proper filter operation. The latter exception is thrown when
 * the values operated on are not within the ranges necessary for filter operation.
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
 * @param <B> - the type of output element produced by the filter
 *
 * @author Shaun Howard
 */
public interface Filter<A extends Comparable<A>, B> {

    /**
     * Returns a filtered value of type B from the specified value of type A by
     * casting the value. The method of filtering the specified value depends on
     * the implementation.
     *
     * @param value - specified value to filter
     * @return value filtered and cast into type B
     * @throws exception.NullValueException - if the input value is null
     * @throws exception.EmptyListException - if any lists under operation are empty
     * @throws exception.IncorrectSizeException - if any variable sizes are out of necessary operating range
     */
    public B filter(A value) throws NullValueException, EmptyListException, IncorrectSizeException;

}
