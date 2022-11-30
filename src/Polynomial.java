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
	  */
	public String toString() {
		String expr = "";

		for (int coIdx = 0; coIdx < degree; coIdx++) {
			Integer co = getCoefficient(coIdx);
			// Concatenate coefficient
			if (co == null) expr += (char)((int)('A') + coIdx);
			else            expr += co;
			// Concatenate x and exponent
			if (coIdx == degree - 1);                           // Nothing if exponent is 0
			else if (coIdx == degree - 2) expr += "x";          // Just "x" if exponent is 1
			else                          expr += "x^" + coIdx; // Else "x^N" if exponent is N
			expr += " + ";
		}

		return expr.substring(0, expr.length() - 3); // To remove the trailing " + "
	}

	/**
	  * Returns the coefficient at the given index, or null if it is still unset
	  *
	  * @param coefficientIdx Index of the coefficient to get
	  */
	public Integer getCoefficient(int coefficientIdx) {
		int coStart = 0, coEnd = -1;
		for (int i = 0; i < coefficientIdx + 1; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coEnd);
		}
		return new Integer(coefficients.substring(coStart, coEnd));
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
			coEnd = coefficients.index(",", coEnd);
		}

		coefficients = 
			coefficients.substring(0, coStart) + coefficient +
			coefficients.substring(coEnd);
	}
}
