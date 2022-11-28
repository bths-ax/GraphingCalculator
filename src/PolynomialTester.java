public class PolynomialTester {
	public static void main(String[] args) {
		// x^2 + 2x - 24
		// roots: -6, 4
		Polynomial poly = new Polynomial(3);
		poly.addCoefficient(1);
		poly.addCoefficient(2);
		poly.addCoefficient(-24);

		System.out.println(poly.evaluate(-6)); // expecting 0
		System.out.println(poly.evaluate(4)); // expecting 0
		System.out.println(poly.evaluate(0)); // expecting -24
		System.out.println(poly.evaluate(1)); // expecting -21
		System.out.println(poly.evaluate(2)); // expecting -16
	}
}
