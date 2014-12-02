package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * <p>
 * A scalar filter designed to produce a distinctly filtered Double output value.
 * The output value depends on both the input value provided by the user and previously
 * entered values specified in previous calls to the filter method. The user of this interface
 * has precise control over when and what value is filtered. A range of the previously entered
 * input values are accessible to the user after filtering. The range of tracked input values
 * may be the size of the data structure that tracks input for filtering values. The accession
 * of variables may vary depending on implementation.
 * </p>
 * <p>
 * The ScalarFilter interface provides one method to filter a specified Double value. The method
 * should perform within a maximum of linear time operation depending on the implementation. The value
 * returned by the filter method will have an exact precision because the output value maintains a Double
 * type.
 * </p>
 * <p>
 * All scalar filter implementations have restrictions on the elements they may filter. For example,
 * all implementations prohibit null elements and some have restrictions on the types of their elements.
 * Attempting to add an ineligible element throws an unchecked NullValueException.
 * </p>
 * <p>
 * Unchecked EmptyListException and IncorrectSizeExceptions are thrown when the implementation utilizes
 * a validation from the FilterValidator class. The earlier exception is thrown when the list operated on
 * contains zero elements but should contain at least one element for proper filter operation. The latter exception is thrown when
 * the values operated on are not within the ranges necessary for filter operation.
 * </p>
 * 
 * @author Shaun Howard
 */
public interface ScalarFilter extends Filter<Double, Double> {

    /**
     * Returns a filtered value of type Double from the specified value of type Double.
     * The method of filtering the specified value depends on
     * the implementation.
     *
     * @param value - specified value to filter
     * @return value filtered as type Double
     * @throws exception.NullValueException - if the input value is null
     * @throws exception.EmptyListException - if any lists under operation are empty
     * @throws exception.IncorrectSizeException - if any variable sizes are out of necessary operating range
     */
    public Double filter(Double value) throws NullValueException, EmptyListException, IncorrectSizeException;

    /**
     * Resets the scalar filter implementation with a Double value equivalent to zero.
     */
    public void reset();
}
