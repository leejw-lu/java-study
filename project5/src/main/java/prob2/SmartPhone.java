package prob2;

public class SmartPhone extends MusicPhone {
	
	//스마트폰 적당히 오버라이딩 해서 
	// 통화 들어오면 그대로
	// 앱실행 앱 실행으로 바꾸기
	
	@Override
	public void execute( String function ) {
		if (function == "음악") {
			playMusic();
		} else if (function=="앱") {
			app();
		} else {
			super.execute(function);	//통화
		}
	}
	
	@Override
	protected void playMusic() {
		System.out.println( "다운로드해서 음악재생" );
	}
	
	private void app(){
		System.out.println( "앱실행" );
	}

}
