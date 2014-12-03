package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * A linear implementation of the ScalarFilter interface. Implements all ScalarFilter
 * operations. This class also implements the Resettable interface with a type of Double.
 * Implements all Resettable operations. In addition to implementing the ScalarFilter and
 * Resettable interfaces, this class provides methods to calculate the input and output sums
 * with the given linear equation: (y(i) + a(1)y(i-1)+...+a(M)y(i-M) = b(0)x(i)+...+b(N)x(i-N)).
 * This linear equation considers lists of input values specified upon construction, which are where the
 * 'a' and 'b' indexed values come from in the equation. Boundary coefficients are used to limit the calculations
 * of the linear equation on both the input (N) and output (M) sum sides of the equation as in the equation above.
 * </p>
 * <p>
 * The sumInput(), sumOutput(), and reset operations run in linear time. The remaining operations
 * run in constant time.
 * </p>
 * <p>
 * The filter operation calls sumInput() and sumOutput() to calculate the filtered output, y(i) of the current iteration
 * of the filter call. Each call to filter increments the iteration of the ScalarLinearFilter instance.
 * The sumInput() operation performs the summation of the following portion of the linear equation: b(0)x(i)+...+b(N)x(i-N)).
 * The sumOutput() operation performs the summation of the remaining portion of the linear equation: a(1)y(i-1)+...+a(M)y(i-M).
 * </p>
 * <p>
 * Each ScalarLinearFilter instance tracks the current iteration of filter call in order to calculate the value
 * filtered via the above linear equation. The iteration is represented as 'i' in the equation. The sumInput()
 * and sumOutput() methods only perform calculations when the current iteration is greater than or equal to either N
 * or M in order to avoid unnecessary zero-valued additions to the input and output sums.
 * </p>
 * <p>
 * This implementation of Resettable accepts a Double value to reset itself. The resettable method sets the input
 * sum of the instance to the specified Double value. It sets the output sum of the instance to
 * r(sum of b(0)-b(N)) / (1 + sum of a(1) - a(M)), where r is the specified reset value.
 * Calling the reset() operation simply calls reset(Double value) with a Double zero.
 * </p>
 * <p>
 * A ScalarLinearFilter limits the number of calculations per instance based on the input and output boundary coefficient.
 * The instance must be reset once it's threshold is reached in order to calculate any additional filtered values.
 * </p>
 *
 * @author Shaun Howard
 */
public class ScalarLinearFilter implements ScalarFilter, Resettable<Double> {

    // The output boundary coefficient for the linear equation.
    private int M;

    // The input boundary coefficient for the linear equation.
    private int N;

    // The current iteration of the filter.
    private int i;

    // The sum of the input.
    private double inputSum;

    // The sum of the output.
    private double outputSum;

    // The output multiplier list.
    private List<Double> a;

    // The input multiplier list.
    private List<Double> b;

    // The previous input list.
    private List<Double> x;

    // The previous output list.
    private List<Double> y;

    /**
     * Constructs a ScalarLinearFilter with boundary coefficients N and M
     * and lists of multipliers a and b for input and output consecutively.
     *
     * @param M - the output boundary coefficient
     * @param N - the input boundary coefficient
     * @param a - the multiplier list for output
     * @param b - the multiplier list for input
     */
    public ScalarLinearFilter(int M, int N, ArrayList<Double> a, ArrayList<Double> b){
        this.M = M;
        this.N = N;
        this.a = a;
        this.b = b;
        this.i = 0;
        this.inputSum = 0;
        this.outputSum = 0;
        x = new ArrayList<>(Collections.nCopies(M, 0.0));
        y = new ArrayList<>(Collections.nCopies(N, 0.0));
    }

    /**
     * <p>
     * Filters the specified input value by subtracting the sum of the input portion of the equation from the sum of the
     * output portion of the equation. The sum of the input portion is provided via a call to sumInput() method after the
     * specified input value is added to the set of input values.
     * The sum of the output portion is provided via a call to the sumOutput() method.
     * The output is added to the list of output values after calculation.
     * Each call to the filter method increments the iteration of this ScalarLinearFilter instance.
     * </p>
     * <p>
     * When the current iteration of filtering is beyond the range of either the input or output list's size, a checked
     * IncorrectSizeException will be thrown.
     * </p>
     *
     * @param in - the input value to filter based on the scalar linear equation
     * @return the output value y(i) of the linear equation solution
     * @throws exception.NullValueException - if null data structure references on operated structures or null input
     * @throws exception.IncorrectSizeException - if current iteration is beyond the size of both the input and output
     * list sizes
     * @throws exception.EmptyListException - if a data structure used for calculation is empty but must not be
     */
    @Override
    public Double filter(Double in) throws NullValueException, IncorrectSizeException, EmptyListException {
        FilterValidator.throwExceptionWhenNull(in, a, b);
        FilterValidator.throwWhenOutOfRange(i, 0, x.size());
        FilterValidator.throwWhenOutOfRange(i, 0, y.size());
        x.add(i, in);
        double out = sumInput() - sumOutput();
        y.add(i, out);
        i++;
        return out;
    }

    /**
     * Resets the filter by calling reset(Double value) with a Double zero.
     * Inherently catches a NullValueException and prints a message to standard error
     * stream when the called method errors due to a null input value, although this should never happen.
     */
    @Override
    public void reset() {
        try {
            reset(0.0);
        } catch (NullValueException e) {
            System.err.println("Error resetting scalar linear filter with 0.0.");
        }
    }

    /**
     * Calculates the right (input) side of the scalar linear equation.
     * This calculation is the sum of input as b(n) * x(i-n), where n starts at 0 and ends at N
     * and i is the current iteration of filtering.
     *
     * @return the sum of the input side of the scalar linear equation
     * @throws exception.EmptyListException - if value lists b or x are empty
     * @throws exception.IncorrectSizeException - if the size of value list b is not equal to N
     */
    private double sumInput() throws IncorrectSizeException, EmptyListException {
        FilterValidator.throwExceptionWhenEmpty(b, x);
        FilterValidator.throwIncorrectSizeException(b, N);

        double sum = 0;
        IN_SUM_LOOP:
        for (int n = 0; n < N; n++){
            //sum = sum + b(n) * x(i-n)
            if ((i - n) >= 0) {
                sum += b.get(n) * x.get(i - n);
            } else {
                //will only add zeroes to sum, so break
                break IN_SUM_LOOP;
            }
        }

        return sum + inputSum;
    }

    /**
     * Calculates the left (output) side of the linear equation without adding the
     * output, y(i), of the current iteration i.
     * This calculation is the sum of output as a(m) * y(i-m), where m starts at 1 and ends at M
     * and i is the current iteration of filtering.
     *
     * @return the sum of the output side of the scalar linear equation without the output, y(i), included
     * @throws exception.IncorrectSizeException - if the size of value list a is not equal to M
     */
    private double sumOutput() throws IncorrectSizeException {
        FilterValidator.throwIncorrectSizeException(a, M);

        double sum = 0;
        OUT_SUM_LOOP:
        for (int m = 1; m < M; m++){
            //sum = sum + a(m) * y(i-m)
            if ((i - m) >= 0) {
                sum += a.get(m) * y.get(i - m);
            } else {
                //will only add zeroes to sum, so break
                break OUT_SUM_LOOP;
            }
        }

        return sum + outputSum;
    }

    /**
     * Resets the filter with the specified value r.
     * Sets the record of previous input value to r.
     * Sets the record of previous output value to the calculation
     * r(sum of b(0)-b(N)) / (1 + sum of a(1) - a(M)).
     *
     * @param r - the value to reset the filter with
     * @throws exception.NullValueException - if any value used in
     * resetting filter is null, i.e. input value r, value lists a or b
     */
    @Override
    public void reset(Double r) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(r, b, a);
        double dividend = 0;
        double quotient = 1;
        for (int n = 0; n < N; n++){
            dividend += b.get(n);
        }
        for (int m = 1; m < M; m++){
            quotient += a.get(m);
        }
        i = 0;
        inputSum = r;
        dividend = r * dividend;
        outputSum = dividend / quotient;
    }

    /**
     * Gets the input boundary coefficient of the scalar linear equation.
     *
     * @return the input boundary coefficient of the scalar linear equation
     */
    public int getN() {
        return N;
    }

    /**
     * Gets a list representation of input multipliers for the scalar linear equation.
     *
     * @return a list of input multipliers for the scalar linear equation
     */
    public List<Double> getB() {
        return b;
    }

    /**
     * Gets the filtered input sum calculated on the last iteration of the filter method.
     *
     * @return the input sum calculated up until the last filter iteration
     */
    public double getInputSum(){
        return this.inputSum;
    }

    /**
     * Gets the filtered output sum calculated on the last iteration of the filter method.
     *
     * @return the output sum calculated up until the last filter iteration
     */
    public double getOutputSum(){
        return this.outputSum;
    }
}
