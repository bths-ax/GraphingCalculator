public class Polynomial {
	public int coefficientCnt;
	private String coefficients; // not an array because "we didnt learn that yet" and i have a problem

	public Polynomial(int coefficientCnt) {
		this.coefficientCnt = coefficientCnt;
		this.coefficients = new String();
	}

	public void addCoefficient(int coefficient) {
		// String format: "A,B,C,"
		// For expression: Ax^2 + Bx + C
		coefficients += coefficient + ",";
	}

	// so funny story!
	// i was originally planning on making the coefficients doubles,
	// which meant i could return Double.NaN for coefficients that
	// didn't exist, but then i thought that doubles would be
	// too annoying to deal with when printing, so i changed them to
	// integers, but there was no NaN-like value for integers, sooooo...
	// lol
	public Integer getCoefficient(int index) {
		int coStart = 0;
		int coEnd = -1;

		// Parse coefficients string by finding the `index`th comma
		for (int i = 0; i < index; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coStart);
			if (coEnd == -1) { // `index`th coefficient doesn't exist
				return null;
			}
		}

		return Integer.parseInt(coefficients.substring(coStart, coEnd));
	}

	// Calculates Ax^N + Bx^(N - 1) + ... by iterating through the coefficients
	// Assume called only after all coefficients are added
	public double evaluate(double x) {
		double result = 0;
		for (int i = 1; i <= coefficientCnt; i++)
			result += getCoefficient(i) * Math.pow(x, coefficientCnt - i);
		return result;
	}

	// Returns a string containing the polynomial equation in its
	// empty form, with all the coefficients indexed
	public String visualizeEquation() {
		String eqStr = "y = ", idxStr = "";

		for (int i = 1; i <= coefficientCnt; i++) {
			// Pad `idxStr` to match `eqStr`'s length
			for (int j = idxStr.length(); j < eqStr.length(); j++)
				idxStr += " ";
			// Add empty coefficient and index
			eqStr += "_";
			idxStr += i;
			// Add the "x" portion
			if (i == coefficientCnt);                       // Don't add anything if exponent is 0
			else if (i == coefficientCnt - 1) eqStr += "x"; // Add "x" if exponent is 1
			else eqStr += "x^" + (coefficientCnt - i);      // Add "x^N" if exponent > 1
			eqStr += " + "; // Make sure to remove the trailing + at the end
		}

		return eqStr.substring(0, eqStr.length() - 3) + "\n" + idxStr;
	}

	public String visualizeGraph(int minX, int maxX, int minY, int maxY, int width, int height) { // text based rendering oh god
		return ""; // TODO
	}
}
