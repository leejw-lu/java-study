package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT=6019;
	
	public static void main(String[] args) {
		// chat 서버 스레드 만들어서 print wirte list 넘기기
		List<Writer> listWriters = new ArrayList<Writer>();
		
		//1. 서버 소켓 생성
		ServerSocket serverSocket=null;
		
		try {
			serverSocket= new ServerSocket();
			
			//2. 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("연결 기다림 " +  PORT);
			
			//3. 요청 대기
			while(true) {
				Socket socket= serverSocket.accept();	// blocking
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			log("error: "+ e);
		} finally {
			try {
				if (serverSocket!=null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Server] "+ message);
	}
	
}

	
