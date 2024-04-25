package tv;

public class TV {
	private int volume;  	//0~100
	private int channel; 	//1~255
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel=channel;
		this.volume=volume;
		this.power=power;
	}
	
	public void power(boolean on) {
		this.power=on;
	}
	
	public void channel(int channel) {	//1~255 유지
		if (channel<1) {	
			this.channel=255;
		}else if (channel>255){
			this.channel=1;
		}else {
			this.channel=channel;
		}
	}
	
	public void channel(boolean up) {	//1~225 유지, 1씩 증감
		
		if (up) {
			channel+=1;
			if (channel==256) {
				channel=1;
			}
		}else {
			channel-=1;
			if (channel==0) {
				channel=255;
			}
		}

	}
	
	public void volume(int volume) {	//0~100유지
		if (volume<0) {	
			this.volume=100;
		}else if (volume>100){
			this.volume=0;
		}else {
			this.volume=volume;
		}
	}
	
	public void volume(boolean up) { //메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
		
		if (up) {
			volume+=1;
			if (volume==101) volume=0;
		}
		else {
			volume-=1;
			if (volume==-1) volume=100;
		}

	}

	public void status() {
		String status;
		if (power) {
			status="on";
		}else {
			status="off";
		}
		
		System.out.print("TV[power=" + status + "] ");
		System.out.println("volume: " + volume + ", channel: "+ channel);
	}
	
	//채널, 볼륨 하나씩  증가 디지털 + 아날로그 2개 만들기
	//255 넘어가는 경우 -> 1로 라운딩 시키기 channel%255
	//음량도 rotate되게
	
	//setter, getter 만들지 말기
	//가능한 최대한 중복코드 없이!!
	
}
