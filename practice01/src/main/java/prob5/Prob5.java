package prob5;

public class Prob5 {
	public static void main(String[] args) {
		
		for (int num=1;num<100;num++) {
			String s= String.valueOf(num);
			String result= s+ " ";
			boolean clap=false;
			
			for (int i=0; i<s.length(); i++) {
				char c= s.charAt(i);
				if (c=='3' || c=='6' || c=='9') {
					result+="짝";
					clap=true;
				}	
			}
			if (clap)
				System.out.println(result);
		}
	}
}
