package prob6;

public abstract class Shape {

	double width, height;
	
	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	protected abstract double getArea();		// 넓이
	protected abstract double getPerimeter();	// 둘레 길이

}
