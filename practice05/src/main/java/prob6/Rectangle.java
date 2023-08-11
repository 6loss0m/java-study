package prob6;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(double width, double height) {
		super(width, height);
	}

	@Override
	protected double getArea() {
		return width * height;
	}

	@Override
	protected double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double d) {
		width = width * d;
		height = height * d;
	}

}
