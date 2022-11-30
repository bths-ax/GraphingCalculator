# Project Planning

## Polynomial

	* private int degree
	* private String coefficients
		- Formatted as: "A,B,C,"
		- Representing expression: Ax^2 + Bx + C

	* public Polynomial()
		- Defaults degree to 3 and sets up coefficients string
	* public Polynomial(int degree)
		- Sets degree to `degree` and sets up coefficients string

	* public String toString()
		- Returns polynomial expression in standard form

	* public Integer getCoefficient(int coefficientIdx)
		- Gets the coefficient at the given index (null if still unset)
	* public void setCoefficient(int coefficientIdx, Integer coefficient)
		- Sets the coefficient at the given index to `coefficient`

	* public double evaluate(double x)
		- Evaluates the polynomial expression, substituting in `x` for x

	* public String visualizeGraph(int width, int height, int minX, int maxX, int minY, int maxY)
		- Returns polynomial graph with:
			- Resolution: width x height
			- X Bounds: [minX, maxX]
			- Y Bounds: [minY, maxY]

## Main

	1. Accepts user input for polynomial degree and coefficients
	2. Accepts user input for graph details
	3. Visualizes the graph and prints it out
