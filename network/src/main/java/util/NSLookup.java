package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		try {
			//스캐너 써저 www.naver.com 입력받기
			InetAddress[] inetAddresses= InetAddress.getAllByName("www.naver.com");

			for (InetAddress inetAddresse : inetAddresses) {
				System.out.println(inetAddresse);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
