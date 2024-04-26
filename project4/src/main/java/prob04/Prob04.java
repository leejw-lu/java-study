package prob04;

public class Prob04 {

	public static void main(String[] args) {
		
		//point의 colorpoint 색깔도 나오는 것 처럼 . 부서까지 나오게 하라. 오버라이드 문제
		//department는 employee에서 상속을 받아야 한다.
		Employee pt = new Depart( "홍길동", 3000, "개발부" );
		pt.getInformation();
	}
}