package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		
		// public은 접근제한이 없다.
		goods.name="camera";
		
		// proteded는 같은 패키지에서 접근이 가능하다.
		// 더 중요한 것은 자식에서 접근이 가능하다.
		// goods.price=20000;
		
		// default는 같은 패키지에서 접근이 가능하다.
		// goods.countStock=10;
		
		// private는 내부에서만 접근이 가능하다.
		// goods.countSold=20;
		
	}

}
