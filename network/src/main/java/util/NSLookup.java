package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			//스캐너 써저 www.naver.com 입력받기
			Scanner scanner = new Scanner(System.in);
			while (true) { 
				System.out.print(">");
				String line = scanner.nextLine();
				
				if (line.equals("exit")) {
					break;
				}
				InetAddress[] inetAddresses= InetAddress.getAllByName(line);  //"www.naver.com"

				for (InetAddress inetAddresse : inetAddresses) {
					System.out.println(inetAddresse);
				}

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
