package com.prueba1;

public class Circle extends Shape{
	
	/**
	 * Point that indicates the center of the circle;
	 */
	private Point center;
	/**
	 * Get function for the center point;
	 */
	public Point getCenter() {return center;}
	

	/**
	 * Point that indicates a border of the circle;
	 */
	private Point border;
	/**
	 * Get function for the border point;
	 */
	public Point getBorder() {return border;}

	/**
	 * Value of the circle's radius;
	 */
	private double radius;
	/**
	 * Get function for the radius value;
	 */
	public double getRadius() {return radius;}

	/**
	 * Constructor of the class Circle.<br/>
	 * @param center Point that defines the center position of the circle.
	 * @param side Point that will define radius and size of the circle.
	 */
	public Circle(Point center, Point side)
	{
		this.center = center;
		this.border = side;
		
		radius = center.DistanceBetweenPoints(side);
	}

	/**
	 * Constructor of the class Circle.<br/>
	 * This function will create the border Point exactly to the right of the center Point.
	 * @param center Point that defines the center position of the circle.
	 * @param radius The size of the radius of the circle.
	 */
	public Circle(Point center, double radius)
	{
		this.center = center;
		this.radius = radius;
		
		border = new Point( center.getX() + radius, center.getY() );
	}

	/**
	 * Constructor of the class Circle.<br/>
	 * This function will create the border Point exactly to the right of the given X  center coordinates.
	 * @param centerX Coordinate X for the center position of the circle.
	 * @param centerY Coordinate Y for the center position of the circle.
	 * @param radius The size of the radius of the circle.
	 */
	public Circle(double centerX, double centerY, double radius)
	{
		this(new Point(centerX,centerY), radius);
	}

	/**
	 * Constructor of the class Circle.<br/>
	 * This function will create both the center and border Points for the circle using the given coordinates.
	 * @param centerX Coordinate X for the center position of the circle.
	 * @param centerY Coordinate Y for the center position of the circle.
	 * @param borderX Coordinate X for the border Point position of the circle.
	 * @param borderY Coordinate Y for the border Point position of the circle.
	 */
	public Circle(double centerX, double centerY, double borderX, double borderY)
	{
		this(new Point(centerX,centerY), new Point(borderX,borderY));
	}



	/**
	 * Calculates the distance between the center point of the circle and the Point given.
	 * @param point The point to which the distance need to be calculated. 
	 * @return the value (double) of the distance.
	 */
	@Override
	public double DistanceToPoint(Point point)
	{
		return center.DistanceBetweenPoints(point);
	}

	/**
	 * Calculates the distance between the center point of the circle and the Point given.
	 * @param axisX The coordinate X to the point to which the distance need to be calculated.
	 * @param axisY The coordinate Y to the point to which the distance need to be calculated.
	 * @return the value (double) of the distance.
	 */
	@Override
	public double DistanceToCoords(double axisX, double axisY)
	{
		return center.DistanceBetweenPoints(new Point(axisX,axisY));
	}

	/**
	 * Calculates the circle's perimeter.
	 * @return the value (double) of the perimeter.
	 */
	@Override
	public double Perimeter()
	{
		return 2*Math.PI*radius;
	}

	/**
	 * Calculates the circle's area.
	 * @return the value (double) of the area.
	 */
	@Override
	public double Area()
	{
		return Math.PI*radius*radius;
	}

	/**
	 * Generate a summary text for the circle.
	 * @return the description's text (string)
	 */
	public String toString()
	{
		return "Circle - (" + center.getX() + " X; " + center.getY() + " Y) with Radius: " + getRadius() ;
	}
}
