package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] count = new int[ MONEYS.length ];
		
		/* 코드 작성 */
		System.out.print("금액: ");
		int totalMoney=scanner.nextInt();
		System.out.println();
		
		//개수 count
		for (int i=0;i<MONEYS.length;i++) {
			count[i]=totalMoney/MONEYS[i];
			totalMoney%=MONEYS[i];
		}
		
		//출력
		for (int i=0;i<MONEYS.length;i++) {
			System.out.println(MONEYS[i]+"원 : "+ count[i]+"개");
		}
		
		scanner.close();
 	}
}