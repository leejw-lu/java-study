package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera= new Goods("nikon", 400000, 10, 20);
//		camera.setName("nikon");
//		camera.setPrice(400000);
//		camera.setCountSold(10);
//		camera.setCountStock(20);
		
		camera.showInfo();
		
		// 정보은닉(데이터보호)
		// camera.setPrice(-400000);
		
		// static 변수(클래스 변수)
		Goods goods2=new Goods();
		Goods goods3=new Goods();
		System.out.println(Goods.countOfGoods);
		
		System.out.println(camera.calcDiscountPrice(0.5f));
		
		System.out.println(camera);
		
		System.out.println(camera.toString());	//Goods 부모 Object의 메서드 사용 가능
	}

}
