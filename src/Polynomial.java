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
			else                          expr += "x^" + (degree - coIdx - 1); // Else "x^N" if exponent is N (remember that 0 is the highest exponent)
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
		// Get start and end indexes of the `coefficientIdx`th coefficient
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
		// Get start and end indexes of the `coefficientIdx`th coefficient
		int coStart = 0, coEnd = -1;
		for (int i = 0; i < coefficientIdx + 1; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coStart);
		}

		// Cut out the old coefficient and add the new one in
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
	public String visualizeGraph(int width, int height, double minX, double maxX, double minY, double maxY) {
		String graphStr = "";

		for (int y = height - 1; y >= 0; y--) { // Printing up -> down: greater -> lesser y values
			graphStr += "|"; // optional aesthetics (frame for the graph, left side)
			for (int x = 0; x < width; x++) {   // Printing left -> right: lesser -> greater x values
				// Each pixel takes up some portion of the graph, so get the bounds of each pixel
				double graphXLeft  = (double)(x    ) / width * (maxX - minX) + minX;
				double graphXRight = (double)(x + 1) / width * (maxX - minX) + minX;
				double graphYBot = (double)(y    ) / height * (maxY - minY) + minY;
				double graphYTop = (double)(y + 1) / height * (maxY - minY) + minY;

				String graphPixel = " ";

				// Show the axis if the pixel should contain it
				boolean isXAxis = graphYBot <= 0 && 0 <= graphYTop;
				boolean isYAxis = graphXLeft <= 0 && 0 <= graphXRight;

				if (isXAxis && isYAxis) graphPixel = "+"; // Congratulations you're the one pixel where the axis cross each other!
				else if (isXAxis) graphPixel = "-";
				else if (isYAxis) graphPixel = "|";

				// Show the graph if the pixel should contain it
				// Split each pixel into 24 parts (not including the edges)
				for (int i = 1; i < 25; i++) {
					// Evaluate the expression for the x value at that portion of the pixel
					double exprX = i/25.0 * (graphXRight - graphXLeft) + graphXLeft;
					double exprY = evaluate(exprX);

					// Check if the result is within the bounds of the pixel
					// If it is, that means that this pixel should be shaded
					if (graphYBot <= exprY && exprY < graphYTop) {
						graphPixel = "*";
					}
				}

				graphStr += graphPixel;
			}
			graphStr += "|"; // optional aesthetics (frame for the graph, right side)
			graphStr += "\n";
		}

		graphStr = // optional aesthetics (frame for the graph, top and bottom)
			"+" + "-".repeat(width) + "+\n" + graphStr +
			"+" + "-".repeat(width) + "+";

		return graphStr;
	}
}
