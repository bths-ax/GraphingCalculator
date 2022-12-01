/**
  * Represents a variable degree polynomial
  */
public class Polynomial {
	private int degree;
	private String coefficients;

	/**
	  * Constructs an empty polynomial with a default degree of 3
	  */
	public Polynomial() {
		this(3);
	}

	/**
	  * Constructs an empty polynomial with a specified degree
	  *
	  * @param degree Degree of the polynomial
	  */
	public Polynomial(int degree) {
		this.degree = degree;
		this.coefficients = ",".repeat(degree); // thanks java for not documenting this method!
	}

	/**
	  * Returns a string of the polynomial expression in standard form:
	  * Ax^N + Bx^(N - 1) + ... + Cx + D
	  *
	  * Replaces coefficients with a variable if unset
	  * (As there are only 26 letters, the degree should not be higher)
	  *
	  * @return String - Polynomial expression in standard form
	  */
	public String toString() {
		String expr = "";

		for (int coIdx = 0; coIdx < degree; coIdx++) {
			Integer co = getCoefficient(coIdx);
			// Concatenate coefficient
			if (co == null) expr += (char)((int)('A') + coIdx);
			else            expr += co;
			// Concatenate x and exponent
			if (coIdx == degree - 1);                                          // Nothing if exponent is 0
			else if (coIdx == degree - 2) expr += "x";                         // Just "x" if exponent is 1
			else                          expr += "x^" + (degree - coIdx - 1); // Else "x^N" if exponent is N (Remember that 0 is the highest exponent)
			expr += " + ";
		}

		return expr.substring(0, expr.length() - 3); // To remove the trailing " + "
	}

	/**
	  * Returns the degree of the polynomial
	  * 
	  * @return int - Degree of the polynomial
	  */
	public int getDegree() { return degree; }

	/**
	  * Returns the coefficient at the given index, or null if it is still unset
	  *
	  * @param coefficientIdx Index of the coefficient to get
	  * @return Integer - Coefficient at the given index
	  */
	public Integer getCoefficient(int coefficientIdx) {
		int coStart = 0, coEnd = -1;
		for (int i = 0; i < coefficientIdx + 1; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coStart);
		}

		if (coEnd - coStart == 0) // Coefficient isn't set yet (empty string)
			return null;
		return Integer.parseInt(coefficients.substring(coStart, coEnd));
	}

	/**
	  * Sets the coefficient at the given index
	  *
	  * @param coefficientIdx Index of the coefficient to set
	  * @param coefficient    Coefficient to set
	  */
	public void setCoefficient(int coefficientIdx, Integer coefficient) {
		int coStart = 0, coEnd = -1;
		for (int i = 0; i < coefficientIdx + 1; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coStart);
		}

		coefficients = 
			coefficients.substring(0, coStart) + coefficient +
			coefficients.substring(coEnd);
	}

	/**
	  * Evaluates the polynomial expression, substituting a given value for x
	  *
	  * Assumes that all coefficients are already set
	  *
	  * @param x Value to substitute in for x
	  * @return double - Result of evaluating the polynomial expression
	  */
	public double evaluate(double x) {
		double result = 0;
		for (int coIdx = 0; coIdx < degree; coIdx++)
			result += getCoefficient(coIdx) * Math.pow(x, degree - coIdx - 1);
		return result;
	}

	/**
	  * Returns a string of a visualization of the polynomial graph
	  * using ASCII characters, generated with the given options
	  *
	  * @param width  The width of the visualization
	  * @param height The height of the visualization
	  * @param minX   The minimum x value of the visualization
	  * @param maxX   The maximum x value of the visualization
	  * @param minY   The minimum y value of the visualization
	  * @param mayY   The maximum y value of the visualization
	  *
	  * @return String - Visualization of the polynomial graph
	  */
	public String visualizeGraph(int width, int height, int minX, int maxX, int minY, int maxY) {
		return ""; // TODO: oh god why did i do this to myself
	}
}
