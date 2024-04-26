package prob6;

public class Rectangle extends Shape implements Resizable {
//	private double width;
//	private double height;
	
	public Rectangle(double width, double height) {
		super(width, height);
//		this.width=width;
//		this.height=height;
	}

	//resizable 까지 구현
	@Override
	public void resize(double s) {
		//width*=s;
		//height*=s;
		super.setWidth(super.getWidth()*s);
		super.setHeight(super.getHeight()*s);
	}

	@Override
	public double getArea() {
		//return width*height;
		return super.getWidth()*super.getHeight();
	}

	@Override
	public double getPerimeter() {
		//return (width+height)*2;
		return (super.getWidth()+super.getHeight())*2;
	}
	

}
