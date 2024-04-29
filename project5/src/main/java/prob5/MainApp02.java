package prob5;

public class MainApp02 {

	public static void main(String[] args) throws MyStackException {
		MyStack02 stack = new MyStack02(3);
		stack.push("Hello");
		stack.push("World");
		stack.push("!!!");
		//stack.push("java");
		stack.push(1);
		stack.push(".");

		while (stack.isEmpty() == false) {
			String s = (String) stack.pop();
			System.out.println( s );
		}

		System.out.println("======================================");

		stack = new MyStack02(3);
		stack.push("Hello");

		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
