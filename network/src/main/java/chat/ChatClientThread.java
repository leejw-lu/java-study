package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {

	private BufferedReader br;
	private Socket socket= null;
	
	public ChatClientThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		/*reader를 통해 읽은 데이터 콘솔에 출력하기 (message) 처리*/

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String message;
			while ((message = br.readLine())!= null) {
				System.out.println(message);
			}
			
//			String message= br.readLine();
//			System.out.println(message);
			
		} catch (SocketException e) {
			//ChatClient.log("Socket Exception: " + e);
		} catch (IOException e) {
			//ChatClient.log("error: "+ e);
		}
		
	}
	
}
