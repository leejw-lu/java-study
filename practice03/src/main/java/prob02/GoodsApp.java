package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 생성자를 부른 것이 아니다. Goods 객체의 레퍼런스 값을 저장할 수 있는 공간 5개
		Goods[] goods = new Goods[COUNT_GOODS];	
		
		// 상품 입력
		for (int i=0;i<COUNT_GOODS;i++) {
			String line= scanner.nextLine();
			String[] data= line.split(" ");
			
			String name= data[0];
			int price= Integer.parseInt(data[1]);
			int count= Integer.parseInt(data[2]);
			
			goods[i]= new Goods(name, price, count);
		}
		
		// 상품 출력
		for (int i=0;i<COUNT_GOODS;i++) {
			Goods g= goods[i];
			g.showGoods(g);
		}
		
		// 자원정리
		scanner.close();
	}
}
