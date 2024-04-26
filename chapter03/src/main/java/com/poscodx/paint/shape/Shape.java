package com.poscodx.paint.shape;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.Point;

public abstract class Shape implements Drawable{
	Point[] points;
	String fillColor;
	String lineColor;
	
	//public abstract void draw();	//자식클래스에서 draw() override 해야함
}
