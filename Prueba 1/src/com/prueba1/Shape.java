package com.prueba1;

public abstract class Shape {

	/**
	 * Abstract function assign for the calculation of the shape's area
	 * @return the value of the area as Double
	 */
	public abstract double Area();
	
	/**
	 * Abstract function assign for the calculation of the shape's perimeter
	 * @return the value of the area as Double
	 */
	public abstract double Perimeter();
	
	/**
	 * Abstract function assign for the calculation of the distance between the shape and a given point.
	 * @param point The point to which the distance need to be calculated. 
	 * @return the value of the distance as Double
	 */
	public abstract double DistanceToPoint(Point point);
	
	/**
	 * Abstract function assign for the calculation of the distance between the shape and a given point.
	 * @param axisX The coordinate X to the point to which the distance need to be calculated.
	 * @param axisY The coordinate Y to the point to which the distance need to be calculated.
	 * @return the value of the distance as Double
	 */
	public abstract double DistanceToCoords(double axisX, double axisY);
	
}
