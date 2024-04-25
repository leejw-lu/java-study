package prob02;

public class Goods {
	private String name;
	private int price;
	private int count;
	
	public Goods(String name, int price, int count) {
		this.name= name;
		this.price= price;
		this.count= count;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public void showGoods(Goods g) {
		System.out.println(g.name + "(가격:"+g.getPrice()+"원)이 "+ g.getCount()+"개 입고 되었습니다.");
	}
}
