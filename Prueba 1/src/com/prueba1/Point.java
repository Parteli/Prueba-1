package com.prueba1;

public class Point {

	/**
	 * Coordinate X
	 */
	private double x;
	/**
	 * Get function for the coordinate X
	 */
	public double getX() { return x;}

	/**
	 * Coordinate Y
	 */
	private double y;
	/**
	 * Get function for the coordinate y
	 */
	public double getY() { return y;}

	
	/**
	 * Constructor of the class Point.<br/>
	 * The point will have the coordinates ( 0 , 0 ).
	 */
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}

	
	/**
	 * Constructor of the class Point.
	 * @param x coordinate X of the point.
	 * @param y coordinate Y of the point.
	 */
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculates the distance between 2 given Points.
	 * @param a start point.
	 * @param b end point.
	 * @return The value (double) of the distance.
	 */
	public static double DistanceBetweenPoints(Point a, Point b)
	{
		return DistanceBetweenCoords(a.x, a.y, b.x, b.y);
	}
	
	/**
	 * Calculates the distance between 2 undefined Points given it's coordinates.
	 * @param aX coordinate X from starting point.
	 * @param aY coordinate Y from starting point.
	 * @param bX coordinate X from end point.
	 * @param bY coordinate Y from end point.
	 * @return The value (double) of the distance.
	 */
	public static double DistanceBetweenCoords(double aX, double aY, double bX, double bY)
	{
		if(aX == bX && aY == bY) return 0;
		
		double distance = 0;
		
		double deltaX = bX - aX;
		double deltaY = bY - aY;
		
		distance = Math.sqrt((deltaX*deltaX+deltaY*deltaY));
		
		return distance;
	}

	/**
	 * Calculates the distance between this and the given Point.
	 * @param other The point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceBetweenPoints(Point other)
	{
		return DistanceBetweenCoords(x,y, other.x, other.y);
	}

	/**
	 * Calculates the distance between this point and the given coordinates.
	 * @param axisX The coordinate X to the point to which the distance need to be calculated.
	 * @param axisY The coordinate Y to the point to which the distance need to be calculated.
	 * @return The value (double) of the distance.
	 */
	public double DistanceBetweenPointAndCoords(double axisX, double axisY)
	{
		return DistanceBetweenCoords(x,y, axisX, axisY);
	}

	/**
	 * Generate a summary text for the circle.
	 * @return the description's text (string)
	 */
	@Override
	public String toString()
	{
		return "Point (" + getX() + " X; " + getY() + " Y)";
	}
}