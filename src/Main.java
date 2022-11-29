import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("some scuffed text based graphing calculator thing:tm:");
		System.out.println("serving 50x50px graphs since 2022");
		System.out.println("created by arden xie");
		System.out.println();

		// Assume all inputs are valid (eg. min < max, degree isn't extremely large, etc.)

		// Input polynomial degree
		System.out.print("Degree of polynomial? ");
		int polyDeg = scanner.nextInt();

		// Create polynomial object and visualize expression
		Polynomial poly = new Polynomial(polyDeg);

		System.out.println();
		System.out.println(poly.visualizeEquation());
		System.out.println();

		// Input polynomial coefficients
		for (int i = 1; i <= polyDeg; i++) {
			System.out.print("Coefficient #" + i + ": ");
			int coeff = scanner.nextInt();
			poly.addCoefficient(coeff);
		}

		// Input polynomial graph visualization details
		System.out.print("Graph minimum x: ");
		int visMinX = scanner.nextInt();

		System.out.print("Graph maximum x: ");
		int visMaxX = scanner.nextInt();

		System.out.print("Graph minimum y: ");
		int visMinY = scanner.nextInt();

		System.out.print("Graph maximum y: ");
		int visMaxY = scanner.nextInt();

		System.out.print("Graph width: ");
		int visWid = scanner.nextInt();

		System.out.print("Graph height: ");
		int visHig = scanner.nextInt();

		// Output graph visualization
		System.out.println();
		System.out.println(poly.visualizeGraph(
			visMinX, visMaxX,
			visMinY, visMaxY,
			visWid, visHig
		));
	}
}
