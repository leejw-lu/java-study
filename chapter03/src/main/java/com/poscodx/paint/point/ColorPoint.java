package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		this.x=x; 	//Point에서 x, y를 protected로 변경하면 된다. 지금 private라서 접근 못함.
//		this.y=y;
//		setX(x); 	//이렇게 해도 되긴 되지만...
//		setY(y);
		super(x,y);	//이렇게 부모 생성자 불러서 세팅하자
		this.color=color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void show() {
		System.out.println("점(x=" + getX() + ", x=" + getY()+ ", color="+ color+ ")을 그렸습니다.");
	}
	
}
