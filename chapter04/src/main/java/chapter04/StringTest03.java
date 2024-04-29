package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1= "Hello " + "World" + " java " + 17;
		
//		String s1= new StringBuilder("Hello ")
//						.append("World")
//						.append(" java")
//						.append(17)
//						.toString();
		
		String s1= new StringBuffer("Hello ")
				.append("World")
				.append(" java")
				.append(17)
				.toString();
		
		//System.out.println(s1);

		String s2="";
		for (int i=0;i<1000000; i++) {
			//s2= s2+ "h";
			//s2= new StringBuffer(s2).append("h").toString();	//위의 코드와 동일. new 해서 굉장히 오래걸림.
		}
		
		StringBuffer sb= new StringBuffer("");
		for (int i=0;i<1000000; i++) {
			sb.append("h");
		}
		String s3= sb.toString();
		
		// String methond들...
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));	
		System.out.println(s4.indexOf("abc",7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3,5));
		
		String s5= "         ab    cd     ";
		String s6= "efg,hij,klm,nop,qrs";
		
		String s7=s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("----" + s5.trim() + "----"); //trim: space 없애는 것 ----ab    cd----
		System.out.println("----" + s5.replaceAll(" ", "") + "----"); // ----abcd----
		
		
		String[] tokens= s6.split(",");
		for (String s: tokens) {
			System.out.println(s);
		}
			
		String[] tokens2= s6.split(" ");
		for (String s: tokens2) {
			System.out.println(s);	//원본 출력 (하나짜리)
		}

	}

}
