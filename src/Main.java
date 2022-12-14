import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("some scuffed text based graphing calculator thing:tm:");
		System.out.println("serving 50x50px graphs since 2022");
		System.out.println("created by arden xie");
		System.out.println();

		Polynomial poly;

		// Assume that valid sane values are inputted
		// eg. degree not higher than like 10,
		//     graph width and height are high enough for good resolution,
		//     minimum values are less than maximum values, etc.

		// Accepts user input for polynomial degree
		System.out.print("Degree of polynomial (Enter for default of 2): ");
		String polyDegStr = scanner.nextLine();

		if (polyDegStr.length() == 0) {
			poly = new Polynomial();
		} else {
			poly = new Polynomial(Integer.parseInt(polyDegStr) + 1);
		}

		// Accepts user input for polynomial coefficients
		System.out.println();
		System.out.println("y = " + poly);
		System.out.println();

		for (int coIdx = 0; coIdx < poly.getDegree(); coIdx++) {
			// To print out the coefficient variable name (A-Z)
			// PLEASE PLEASE PLEASE DONT MAKE POLYNOMIALS WITH A DEGREE HIGHER THAN 26
			System.out.print(String.format("Coefficient %c: ", (char)((int)('A') + coIdx)));
			int co = scanner.nextInt();
			poly.setCoefficient(coIdx, co);
		}

		System.out.println();
		System.out.println("Now graphing: y = " + poly);
		System.out.println();

		// Accepts user input for graph details
		System.out.print("Graph width: ");
		int grWidth = scanner.nextInt();
		System.out.print("Graph height: ");
		int grHeight = scanner.nextInt();

		System.out.print("Graph minimum x value: ");
		double grMinX = scanner.nextDouble();
		System.out.print("Graph maximum x value: ");
		double grMaxX = scanner.nextDouble();
		System.out.print("Graph minimum y value: ");
		double grMinY = scanner.nextDouble();
		System.out.print("Graph maximum y value: ");
		double grMaxY = scanner.nextDouble();

		// Visualizes the graph and prints it out
		System.out.println();
		System.out.println(poly.visualizeGraph(
			grWidth, grHeight,
			grMinX, grMaxX,
			grMinY, grMaxY));
		System.out.println();
	}
}
