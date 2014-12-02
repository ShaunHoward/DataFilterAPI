package filter;

import exception.NullValueException;

/**
 * <p>
 * A resettable interface designed to provide reset functionality to a filter.
 * The specified reset value type depends on the generic type A of the filter implemented by the user.
 * The user of this interface has precise control over when and what value is used to reset
 * the filter. No elements provided to the resettable interface will be accessible to the user
 * unless the filter implementation allows access to the previously seen input, in which case
 * the specified reset value will be considered previous input.
 * </p>
 * <p>
 * The Resettable interface provides one method to reset an implementing filter with a specified value.
 * The type of the reset value will vary based on the implementing filter. In all implementations, however,
 * the type of the specified value must extend the Comparable interface.
 * </p>
 * <p>
 * All resettable implementations have restrictions on the elements they may accept to reset
 * the implementing filter. For example, all implementations prohibit null elements and may have type restrictions
 * on their elements, as previously discussed. Attempting to add an ineligible elements throws an unchecked
 * NullValueException.
 * </p>
 *
 * @param <A> - the comparable type of input element to reset the implementing filter with
 *
 * @author Shaun Howard
 */
public interface Resettable<A> {

    /**
     * Resets a generic filter implementations with the specified value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - if the input value is null
     */
    public void reset(A value) throws NullValueException;
}
