package com.prueba1_app;

import com.prueba1.*;

/* Why create an extra class to calculate properties that every shape should have? */
/* This class is useless... all it's functions can be accessed by default in the Shape and Point classes*/
public class Calculator {
	
	
	
	/**
	 * Calculates the triangle's perimeter.
	 * @return the value (double) of the perimeter.
	 */
	public double TrianglePerimeter(Triangle triangle)
	{
		double sideAB = Point.DistanceBetweenPoints(triangle.getVertexA(),triangle.getVertexB());
		double sideBC = Point.DistanceBetweenPoints(triangle.getVertexB(),triangle.getVertexC());
		double sideCA = Point.DistanceBetweenPoints(triangle.getVertexC(),triangle.getVertexA());
		return sideAB+sideBC+sideCA;
	}
	
	/**
	 * Calculates the triangle's area using Heron's Formula.
	 * @return the value (double) of the area.
	 */
	public double TriangleArea(Triangle triangle)
	{
		double sideAB = Point.DistanceBetweenPoints(triangle.getVertexA(),triangle.getVertexB());
		double sideBC = Point.DistanceBetweenPoints(triangle.getVertexB(),triangle.getVertexC());
		double sideCA = Point.DistanceBetweenPoints(triangle.getVertexC(),triangle.getVertexA());
		
		double semiperimeter = (sideAB+sideBC+sideCA)*0.5;

		double side1 = semiperimeter - sideAB;
		double side2 = semiperimeter - sideBC;
		double side3 = semiperimeter - sideCA;
		
		return Math.sqrt(semiperimeter*side1*side2*side3);
	}

	/**
	 * Calculates the circle's perimeter.
	 * @return the value (double) of the perimeter.
	 */
	public double CirclePerimeter(Circle circle)
	{
		return 2*Math.PI*circle.getRadius();
	}

	/**
	 * Calculates the circle's area.
	 * @return the value (double) of the area.
	 */
	public double CircleArea(Circle circle)
	{
		return Math.PI*circle.getRadius()*circle.getRadius();
	}

	
	
	
	
	
	
	/**
	 * Retrieve the area's value of the given SHAPE.
	 * @param circle The object SHAPE that the area is needed.
	 * @return The value (double) of the area.
	 */
	public double getShapeArea( Shape shape)	{ return shape.Area() ;}

	/**
	 * Retrieve the perimeter's value of the given SHAPE.
	 * @param circle The object SHAPE that the perimeter is needed.
	 * @return The value (double) of the perimeter.
	 */
	public double getShapePerimeter( Shape shape)	{ return shape.Perimeter() ;}
	
	

	/**
	 * Retrieve the area's value of the given CIRCLE.
	 * @param circle The object CIRCLE that the area is needed.
	 * @return The value (double) of the area.
	 */
	public double getCircleArea( Circle circle)	{ return circle.Area() ;}
	
	/**
	 * Retrieve the perimeter's value of the given CIRCLE.
	 * @param circle The object CIRCLE that the perimeter is needed.
	 * @return The value (double) of the perimeter.
	 */
	public double getCirclePerimeter( Circle circle)	{ return circle.Perimeter() ;}

	
	/**
	 * Retrieve the area's value of the given TRIANGLE.
	 * @param circle The object TRIANGLE that the area is needed.
	 * @return The value (double) of the area.
	 */
	public double getTriangleArea( Triangle triangle)	{ return triangle.Area() ;}
	/**
	 * Retrieve the perimeter's value of the given TRIANGLE.
	 * @param circle The object TRIANGLE that the perimeter is needed.
	 * @return The value (double) of the perimeter.
	 */
	public double getTrianglePerimeter( Triangle triangle)	{ return triangle.Perimeter() ;}
	
}
