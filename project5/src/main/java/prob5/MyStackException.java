package prob5;

@SuppressWarnings("serial")
public class MyStackException extends Exception {
	
	public MyStackException() {
		super("stack is empty");
	}
}
