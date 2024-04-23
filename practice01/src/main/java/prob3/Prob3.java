package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요: ");
		int num=scanner.nextInt();
		int oddSum=0; 
		int evenSum=0;
		
		for(int i=1;i<=num;i++)
			if (i%2==0)
				evenSum+=i;
			else
				oddSum+=i;
		
		if (num%2==0)
			System.out.print("결과 값: "+ evenSum);
		else
			System.out.print("결과 값: "+ oddSum);
		
		scanner.close();
	}
}
