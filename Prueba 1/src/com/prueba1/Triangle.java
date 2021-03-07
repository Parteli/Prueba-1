package com.prueba1;

public class Triangle extends Shape {

	/**
	 * The Point that defines the first vertex of the triangle.
	 */
	private Point vertexA;
	/**
	 * Get function for the vertexA.
	 */
	public Point getVertexA() {return vertexA;}
	/**
	 * The Point that defines the second vertex of the triangle.
	 */
	private Point vertexB;
	/**
	 * Get function for the vertexB.
	 */
	public Point getVertexB() {return vertexB;}
	/**
	 * The Point that defines the third vertex of the triangle.
	 */
	private Point vertexC;
	/**
	 * Get function for the vertexC.
	 */
	public Point getVertexC() {return vertexC;}

	/**
	 * The size of side defined by the vertex A and B.
	 */
	private double sideAB;
	/**
	 * The size of side defined by the vertex B and C.
	 */
	private double sideBC;
	/**
	 * The size of side defined by the vertex C and A.
	 */
	private double sideCA;
	
	/**
	 * Constructor of the class Triangle.
	 * @param a The Point that will define the vertex A.
	 * @param b The Point that will define the vertex B.
	 * @param c The Point that will define the vertex C.
	 */
	public Triangle (Point a, Point b, Point c)
	{
		this.vertexA = a;
		this.vertexB = b;
		this.vertexC = c;

		sideAB = a.DistanceBetweenPoints(b);
		sideBC = b.DistanceBetweenPoints(c);
		sideCA = c.DistanceBetweenPoints(a);
	}
	
	/**
	 * Constructor of the class Triangle.
	 * @param aX The axis X coordinate for the vertex A.
	 * @param aY The axis Y coordinate for the vertex A.
	 * @param bX The axis X coordinate for the vertex B.
	 * @param bY The axis Y coordinate for the vertex B.
	 * @param cX The axis X coordinate for the vertex C.
	 * @param cY The axis Y coordinate for the vertex C.
	 */
	public Triangle(double aX,double aY,double bX,double bY,double cX,double cY)
	{
		this(new Point(aX,aY), new Point(bX,bY), new Point(cX,cY));
	}

	/**
	 * Calculates the distance between the vertex A and the Point given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterA_Point(Point point)
	{
		return vertexA.DistanceBetweenPoints(point);
	}
	/**
	 * Calculates the distance between the vertex A and the coordinates given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterA_Coords(double axisX, double axisY)
	{
		return vertexA.DistanceBetweenPointAndCoords(axisX, axisY);
	}
	/**
	 * Calculates the distance between the vertex B and the Point given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterB_Point(Point point)
	{
		return vertexB.DistanceBetweenPoints(point);
	}
	/**
	 * Calculates the distance between the vertex B and the coordinates given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterB_Coords(double axisX, double axisY)
	{
		return vertexB.DistanceBetweenPointAndCoords(axisX, axisY);
	}
	/**
	 * Calculates the distance between the vertex C and the Point given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterC_Point(Point point)
	{
		return vertexC.DistanceBetweenPoints(point);
	}
	/**
	 * Calculates the distance between the vertex C and the coordinates given.
	 * @param point The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceVexterC_Coords(double axisX, double axisY)
	{
		return vertexC.DistanceBetweenPointAndCoords(axisX, axisY);
	}

	/**
	 * Calculates and returns the smallest distance between the Point given and one of the vertexes of the triangle.
	 * @return The value (double) of the smallest distance.
	 */
	@Override
	public double DistanceToPoint(Point point)
	{
		double distanceA = DistanceVexterA_Point(point);
		double distanceB = DistanceVexterB_Point(point);
		double distanceC = DistanceVexterC_Point(point);
		
		double distance = 0;
		
		distance = (distanceA <= distanceB)?distanceA:distanceB;
		if(distance > distanceC) distance = distanceC;
		
		return distance;
	}
	/**
	 * Calculates and returns the smallest distance between the coordinates given and one of the vertexes of the triangle.
	 * @return The value (double) of the smallest distance.
	 */
	@Override
	public double DistanceToCoords(double axisX, double axisY) {
		return DistanceToPoint(new Point(axisX, axisY));
	}

	/**
	 * Calculates the triangle's perimeter.
	 * @return the value (double) of the perimeter.
	 */
	@Override
	public double Perimeter()
	{
		return sideAB+sideBC+sideCA;
	}
	
	/**
	 * Calculates the triangle's area Heron's Formula..
	 * @return the value (double) of the area.
	 */
	@Override
	public double Area()
	{
		double semiperimeter = Perimeter()*0.5;

		double side1 = semiperimeter - sideAB;
		double side2 = semiperimeter - sideBC;
		double side3 = semiperimeter - sideCA;
		
		return Math.sqrt(semiperimeter*side1*side2*side3);
	}


	/**
	 * Generate a summary text for the triangle.
	 * @return the description's text (string)
	 */
	public String toString()
	{
		return "Triangle - "+
				"A("+ vertexA.getX() + " X; " + vertexA.getY() + " Y)" +
				"B("+ vertexB.getX() + " X; " + vertexB.getY() + " Y)" +
				"C("+ vertexC.getX() + " X; " + vertexC.getY() + " Y)";
	}

}

