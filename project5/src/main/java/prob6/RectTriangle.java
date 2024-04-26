package prob6;

public class RectTriangle extends Shape{

//	private double width;
//	private double height;
	
	public RectTriangle(double width, double height) {
		super(width, height);
//		this.width=width;
//		this.height=height;
	}

	@Override
	public double getArea() {
		//return width*height*0.5;
		return super.getWidth()*super.getHeight()*0.5;
	}

	@Override
	public double getPerimeter() {
		//return width+height+ Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return super.getWidth()+ super.getHeight()+ Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));
	}

}
