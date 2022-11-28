// TODO: Better comments lol

public class Polynomial {
	public int coefficientCnt;
	private String coefficients; // not an array because "we didnt learn that yet" and i have a problem

	public Polynomial(int coefficientCnt) {
		this.coefficientCnt = coefficientCnt;
		this.coefficients = new String();
	}

	public void addCoefficient(double coefficient) {
		coefficients += String.format("%.2f,", coefficient);
	}

	public double getCoefficient(int index) {
		int coStart = 0;
		int coEnd = -1;

		for (int i = 0; i < index; i++) {
			coStart = coEnd + 1;
			coEnd = coefficients.indexOf(",", coStart);
			if (coEnd == -1) { // Coefficient at given index doesn't exist
				return Double.NaN;
			}
		}

		return Double.parseDouble(coefficients.substring(coStart, coEnd));
	}

	public double evaluate(double x) {
		double result = 0; // Ax^N + Bx^M + ...
		for (int i = 1; i <= coefficientCnt; i++)
			result += getCoefficient(i) * Math.pow(x, coefficientCnt - i);
		return result;
	}

	public String visualizeEquation() {
		return ""; // TODO
	}

	public String visualizeGraph(int minX, int maxX, int minY, int maxY, int width, int height) { // text based rendering oh god
		return ""; // TODO
	}
}
