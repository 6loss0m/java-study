package paint;

import java.awt.font.GraphicAttribute;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
//		point1.setX(10);
//		point1.setY(20);

//		drawPoint(point1);
		draw(point1);
		// point1.disappear();
		point1.show(false);

		Point point2 = new ColorPoint();
		point2.setX(20);
		point2.setY(20);
		
		//ColorPoint p = (ColorPoint)point2;
		((ColorPoint)point2).setColor("blue");
		//p.setColor("Blue");
		
//		drawPoint(point2);
		draw(point2);
		//drawColorPoint(p);
		
		Rect rect = new Rect();
		//drawRect(rect);
//		drawShape(rect); 	// upcasting
		draw(rect); 	// upcasting
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World"));
	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
}
