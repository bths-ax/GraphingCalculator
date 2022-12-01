public class PolynomialTester {
	public static void main(String[] args) {
		// Test default construction
		Polynomial poly3 = new Polynomial();

		System.out.println(poly3.getDegree() == 3);

		// Test setting and getting coefficients / toString()
		poly3.setCoefficient(0, 1);

		System.out.println(poly3.getCoefficient(0) == 1);
		System.out.println(poly3.getCoefficient(1) == null);
		System.out.println(poly3.getCoefficient(2) == null);
		System.out.println(poly3.toString().equals("1x^2 + Bx + C"));

		poly3.setCoefficient(1, 5);

		System.out.println(poly3.getCoefficient(0) == 1);
		System.out.println(poly3.getCoefficient(1) == 5);
		System.out.println(poly3.getCoefficient(2) == null);
		System.out.println(poly3.toString().equals("1x^2 + 5x + C"));

		poly3.setCoefficient(2, 6);

		System.out.println(poly3.getCoefficient(0) == 1);
		System.out.println(poly3.getCoefficient(1) == 5);
		System.out.println(poly3.getCoefficient(2) == 6);
		System.out.println(poly3.toString().equals("1x^2 + 5x + 6"));

		// Test polynomial evaluation
		for (int i = -5; i <= 5; i++) {
			System.out.println(poly3.evaluate(i) == 1 * i * i + 5 * i + 6);
		}

		// Test variable construction
		Polynomial poly5 = new Polynomial(5);

		System.out.println(poly5.getDegree() == 5);
	}
}
