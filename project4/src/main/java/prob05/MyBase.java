package prob05;

public class MyBase extends Base {
	//MyBase만 변경해야함. Base & Prob05.java 건들지 X
	//오버라이드 해야함
	
	@Override
	public void service(String state){		
		if( state.equals( "낮" ) ) {
			day();
		} else if( state.equals( "오후" ) ){
			night();
		} else {
			super.night();
		}
	}
	
	@Override
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	@Override
	public void night(){
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
	
	//	낮에는 열심히 일하자!
	//	night
	//	오후도 낮과 마찬가지로 일해야 합니다.
	

}
