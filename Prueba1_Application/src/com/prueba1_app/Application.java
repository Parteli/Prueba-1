package com.prueba1_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prueba1.Circle;
import com.prueba1.Triangle;
import com.prueba1.Point;
import com.prueba1.Shape;

/*Murilo Oliveira de Carvalho*/


public class Application {

	/**
	 * Reference to the Calculator
	 */
	private static Calculator calc;
	/**
	 * List of Shapes (Circles and Triangles) created by the user.
	 */
	private static List<Shape> shapeList;
	/**
	 * List of Points created by the user.<br/>
	 * This list starts with the origin Point(0,0) by default.
	 */
	private static List<Point> pointList;
	/**
	 * Reference to the input Scanner.
	 */
	private static Scanner scanner;
	
	/**
	 * Starting function of the APP.
	 * @param args
	 */
	public static void main(String[] args) {
		
		calc = new Calculator();

		shapeList = new ArrayList<Shape>();
		pointList = new ArrayList<Point>();
		pointList.add(new Point());
		scanner = new Scanner(System.in);
		NextScreen(0);
	}
	
	/**
	 * Describes the Main Menu of the application. Can access the other menus and close the app.
	 */
	private static void MainMenu() {
		
		String text = "*** Main Menu ***\n";
		text += "1 - Create Point.\n";
		text += "2 - Create Circle.\n";
		text += "3 - Create Triangle.\n";
		text += "4 - Calculate Distance.\n";
		text += "5 - Calculate Area.\n";
		text += "6 - Calculate Perimeter.\n";
		text += "0 - Close Application.\n";
		
		text += "____________________________\nType chosen menu number:";
		
		System.out.println(text);
		
		int input = scanner.nextInt();

		if(input == 0) System.exit(0);
		else NextScreen(input);
	}
	
	/**
	 * Function that identifies the next set of events based on the number the user chose on the Main Menu.
	 * @param next The reference number for the next menu.
	 */
	private static void NextScreen(int next)
	{
		switch(next)
		{
		case 0: MainMenu(); break;
		case 1: CreatePoint(); break;
		case 2: CreateCircle(); break;
		case 3: CreateTriangle(); break;
		case 4: CalculateDistance(); break;
		case 5: CalculateArea(); break;
		case 6: CalculatePerimeter(); break;
		default:
			System.out.println("Error: Invalid destination - Make sure you selected a valid destination.");
			MainMenu();
			break;
		}
	}
	
	/**
	 * Menu that allows the creation of a Point.
	 */
	private static void CreatePoint() {
		System.out.println("\n*** Create Point ***");
		System.out.println("1º Choose the Point's coordinates");
		System.out.println("Axis X: ");
		double x = scanner.nextDouble();
		System.out.println("Axis Y: ");
		double y = scanner.nextDouble();
		
		pointList.add(new Point(x, y));
		
		System.out.println("Point Created: " + pointList.get(pointList.size()-1));
		
		NextScreen(0);
	}

	/**
	 * Menu that allows the creation of a Circle.
	 */
	private static void CreateCircle()
	{
		System.out.println("\n*** Create Circle ***");

		Point centerPoint;
		
		int value = 1;
		
		String[] messages = new String[3];
		messages[0] = "* 1º Choose the circle's center location";
		messages[1] = "to write the coordinates directly.";
		messages[2] = "to select a created POINT.";
		
		value = LoopMenu(messages);
		
		
		if(value == 1)
			centerPoint = ChooseCoordinates("Type the coordinates for the circle's center:");
		else centerPoint = ChoosePoint();
		
		
		messages = new String[4];
		messages[0] = "* 2º Choose the radius or another point to finish the circle";
		messages[1] = "to write the coordinates directly.";
		messages[2] = "to select a created POINT.";
		messages[3] = "for radius.";
		value = LoopMenu(messages);
		

		if(value == 1)
		{
			shapeList.add(
					new Circle( centerPoint,
								ChooseCoordinates("Type the coordinates for the circle's border:")
					)
			);
		}
		else if(value == 2)
		{
			shapeList.add( new Circle(centerPoint,ChoosePoint() ) );
		}
		else
		{
			System.out.println("Type the radius for the circle.");
			double radius = scanner.nextDouble();
			shapeList.add( new Circle(centerPoint, radius) );
		}
		System.out.println("Circle Created: " + shapeList.get(shapeList.size()-1));
		
		NextScreen(0);
	}

	/**
	 * Menu that allows the creation of a Triangle.
	 */
	private static void CreateTriangle()
	{
		int count = 1;
		System.out.println("\n*** Create Triangle ***");

		Point a = null;
		Point b = null;
		Point c = null;

		String[] messages = new String[3];
		messages[0] = "";
		messages[1] = "to write the coordinates directly.";
		messages[2] = "to select a created POINT.";
		
		do
		{
			switch(count)
			{
			case 1:	messages[0]= "1º Create the FIRST vertex.";
			break;
			case 2: a = c; //transferring the FIRST POINT created to variable "a"
				messages[0]= "2º Create the SECOND vertex.";
			break;
			case 3: b = c; //transferring the SECOND POINT created to variable "b"
				messages[0]= "3º Create the THIRD vertex.";
			break;
			}
			
			int value = LoopMenu(messages);
			
			if(value == 1)
				c = ChooseCoordinates("Type the coordinates for the current vertex:");
			else c = ChoosePoint();

			count++;
		}
		while (count <= 3);

		shapeList.add( new Triangle(a,b,c) );
		
		System.out.println("Triangle Created: " + shapeList.get(shapeList.size()-1));
		
		NextScreen(0);
	}

	/**
	 * Menu that allows the calculation of the distance between 2 Points or coordinates.
	 */
	private static void CalculateDistance()
	{
		System.out.println("*** Calculate Distance ***");
		
		Point pA = null;
		Point pB = null;
		int count = 1;
		
		do
		{
			String[] messages;

			if(shapeList.size() > 0)
			{
				messages = new String[4];
				messages[3] = "to select a POINT from a SHAPE.";
			}
			else messages = new String[3];
			
			if(count == 1)
				messages[0] = "* 1º Choose the FIRST POINT or coordinates.";
			else messages[0] = "* 2º Choose the SECOND POINT or coordinates.";
			
			messages[1] = "to write the coordinates directly.";
			messages[2] = "to select a created POINT.";
			
			int value = LoopMenu(messages);
			switch(value)
			{
			case 1: pB = ChooseCoordinates("Type the coordinates:");
				break;
			case 2: pB = ChoosePoint();
				break;
			case 3:
				Shape shape = ChooseShape();

				if( shape.getClass() == Circle.class )
				{
					messages = new String[3]; 
					messages[0] = "Choose a POINT from the CIRCLE:";
					messages[1] = "to select the CENTER " + ((Circle)shape).getCenter().toString();
					messages[2] = "to select the BORDER " + ((Circle)shape).getBorder().toString();
					
					value = LoopMenu(messages);
					pB = value==2?((Circle)shape).getBorder():((Circle)shape).getCenter();
				}
				else if( shape.getClass() == Triangle.class )
				{
					messages = new String[4]; 
					messages[0] = "Choose a POINT from the TRIANGLE:";
					messages[1] = "to select VERTEX A " + ((Triangle)shape).getVertexA().toString();
					messages[2] = "to select VERTEX B " + ((Triangle)shape).getVertexB().toString();
					messages[3] = "to select VERTEX C " + ((Triangle)shape).getVertexC().toString();
					
					value = LoopMenu(messages);
					switch(value) {
					case 1: pB = ((Triangle)shape).getVertexA(); break;
					case 2: pB = ((Triangle)shape).getVertexB(); break;
					case 3: pB = ((Triangle)shape).getVertexC(); break;
					}
				}
				
				break;
			}
			
			if(count == 1) pA = pB; //transferring the FIRST Point to pA;
			count ++;
			
		}
		while(count <= 2);
		
		System.out.println("The distance is " + Point.DistanceBetweenPoints(pA, pB) + " units");
		NextScreen(0);
	}

	/**
	 * Menu that allows the calculation of the area of a Shape.
	 */
	private static void CalculateArea()
	{
		if(shapeList.size() == 0)
		{
			System.out.println("There are no shapes created!");
			NextScreen(0);
			return;
		}
		
		System.out.println("*** Calculate Area ***");
		Shape s = ChooseShape();
		System.out.println("The area is " + calc.getShapeArea(s) + " units square.");

		NextScreen(0);
	}

	/**
	 * Menu that allows the calculation of the perimeter of a Shape.
	 */
	private static void CalculatePerimeter()
	{
		if(shapeList.size() == 0)
		{
			System.out.println("There are no shapes created!");
			NextScreen(0);
			return;
		}
		
		System.out.println("*** Calculate Perimeter ***");
		Shape s = ChooseShape();
		System.out.println("The perimeter is " + calc.getShapePerimeter(s) + " units.");
		
		NextScreen(0);
	}

	/**
	 * Auxiliary function that lists all the Points created and permits the user to select one.
	  * @return The the Point select by the user.
	 */
	private static Point ChoosePoint()
	{
		int p = -1;
		boolean check = false;
		do {
			System.out.println("Choose the ID of a POINT from the list:");
			for(int i=0; i<pointList.size(); i++)
			{
				System.out.println("ID: "+  i + " - " + pointList.get(i).toString() );
			}
			
			p = scanner.nextInt();
			check = (p >= 0 && p < pointList.size());
			if(!check) 
				System.out.println("Invalid ID. Try again.");
		}while (!check);
		
		return pointList.get(p);
	}

	/**
	 * Auxiliary function that lists all the Shapes created and permits the user to select one.
	  * @return The the Shape select by the user.
	 */
	private static Shape ChooseShape()
	{
		int p = -1;
		boolean check = false;
		do {
			System.out.println("Choose a SHAPE from the list:");
			for(int i=0; i<shapeList.size(); i++)
			{
				System.out.println( "ID: "+  i + " - " + shapeList.get(i).toString() );
			}
			
			p = scanner.nextInt();
	
			check = (p >= 0 && p < shapeList.size());
			if(!check) 
			System.out.println("Invalid ID. Try again.");
		}while (!check);
		
		return shapeList.get(p);
	}

	/**
	 * Auxiliary function that receives the coordinates typed by the user and returns a temporary Point.
	 * @return The a Point created with the coordinates typed.
	 */
	private static Point ChooseCoordinates(String message) {
		
		System.out.println(message);
		System.out.println("Axis X: ");
		double x = scanner.nextDouble();
		System.out.println("Axis Y: ");
		double y = scanner.nextDouble();
		return new Point(x,y);
	}

	/**
	 * Auxiliary function that creates a "select menu" where the user has to choose between "1"
	 *  and "Nº" where "Nº" is the length of the String array given minus 1.<br/> 
	 * @param messages List of messages to be displayed. The first message (Array[0]) 
	 * is the menu title and the rest are the choices. The choices are displayed in 
	 * the format 'Type Nº array[Nº]'. The array must have at least 3 Strings inside
	 * (the title and 2 choices).
	 * @return The number (int) of the choice made by the user or -1 if the conditions
	 *  of the array are not met.  
	 */
	private static int LoopMenu( String[] messages) {
		if(messages == null || messages.length < 3) return -1;

		boolean check = false;
		int value = 0;

		do
		{
			String text = messages[0];
			for(int i = 1; i < messages.length; i++)
			{
				text += "\nType \""+ i + "\" " + messages[i];
			}
			System.out.println(text);
			value = scanner.nextInt();
			check = (value > 0 && value < messages.length);
			if(!check) System.out.println("Invalid input... Try again!");
		}
		while (!check);

		return value;
	}
	/*
	private static int selectedShape;
	
	private static void SelectMenu()
	{
		if(shapeList.size() <= 0)
		{
			System.out.println("The list of shapes is still empty. Please create a shape first.");
		}
		else
		{
			System.out.println("Choose a Shape from the list");
			for(int i =0; i < shapeList.size(); i++)
			{
				System.out.println(i+ ": " + shapeList.get(i).toString());
			}
			System.out.println("Select ID: ");
		}
		
		NextScreen(0);
	}
	
	private static void ShapeProperties()
	{
		if(selectedShape < 0)
		{
			System.out.println("No shape is selected. Go back to the main menu and select a shape.");
			NextScreen(0);
		}
		else
		{
			int value = 0;
			do
			{
				Shape shape = shapeList.get(selectedShape);
				System.out.println("\n***Shapes Properties***");
				System.out.println("Id: " + shape.toString());
				System.out.println("Perimeter: " + shape.Perimeter() + "cm");
				System.out.println("Area: " + shape.Area() + "cm2");
				System.out.println("Type \"1\" to insert coordinates find out the distance to the shape.");
				System.out.println("Type \"2\" to go back to the Main Menu");
				value = scanner.nextInt();
				
				if(value == 1)
				{
					System.out.println("Axis X: ");
					double x = scanner.nextDouble();
					System.out.println("Axis Y: ");
					double y = scanner.nextDouble();
					
					System.out.println("Distance to point: " + shape.DistanceToPoint(new Point(x,y)) );
				}
			}
			while(value != 2);
		}

		NextScreen(0);
	}
	*/
	
}