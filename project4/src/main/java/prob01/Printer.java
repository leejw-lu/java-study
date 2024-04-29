package prob01;

public class Printer {
	
//	public void println(int value) {
//		System.out.println(value);
//	}
//	
//	public void println(boolean value) {
//		System.out.println(value);
//	}
//	
//	public void println(double value) {
//		System.out.println(value);
//	}
//	
//	public void println(String value) {
//		System.out.println(value);
//	}
	
	// 오버로딩 안하고 Generic 메소드 사용해도 된다. but, 오버로딩 하는 것이 좋음
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T ... ts) {
		for (T t: ts) {
			System.out.println(t);
		}
	}
	
	public int sum(Integer ... nums) {
		int s=0;
		for (Integer n : nums) {
			s+=n;
		}
		return s;
	}
	
	
	
	
	
}
