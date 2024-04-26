package prob5;

public class MyStack {
	private int size;
	private String[] buffer;
	private int top=0;
	
	public MyStack(int size) {
		this.size=size;
		buffer=new String[size];
	}

	// 사이즈 넘으면 resize 하기 -> 원래사이즈의 2배 만들고 update 시켜주기
	// 옛날 만든 buffer 에 들어있는 값 new 버퍼 배열에 다 복사
	
	public void resize() {
		size*=2;
		String[] temp= new String[size];
		for (int i=0;i<buffer.length;i++) {
			temp[i]=buffer[i];
		}
		buffer=temp;
	}
	
	public void push(String s) {
		if (top>=size) { //사이즈 체크해야함
			resize();
		}
		
		buffer[top]=s;
		top++;
	}
	
	public String pop() throws MyStackException {
		//사이즈 체크해야함 	//exception 처리해야함.
		if (isEmpty()) {
			throw new MyStackException();
		}
		top--;
		return buffer[top];
	}

	public boolean isEmpty() {
		if (top==0) {
			return true;
		}
		return false;
	}
}