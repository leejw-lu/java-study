package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket=null;

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			while( true ) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (!name.isEmpty()) {	//요거 없애기
					break;
				}
				
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}

			//join완료되면 이제 채팅창 띄우기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream() , "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			pw.println("join:" + name);
			
			String data= br.readLine(); 	//blocking
			if (data.equals("join:ok")) {
				System.out.println("입장하셨습니다. 즐거운 채팅되세요");
			}
			
			new ChatWindow(name, socket).show();
			//name 넘기는 이유는.... window 창에 둘리라고 띄우려고. 사실상 소켓을 넘겨야 한다.
			
		} catch (SocketException e) {
			log("Socket Exception: " + e);
		} catch (IOException e) {
			log("error:"+ e);
		}

		// java에서는 GUI 열면 ChatWindow.show에서 멈추는 것이 아니라 쭉 내려가기 때문에
		// 자원정리는 ChatWindow에서 하면 된다. 여기서 하면 바로 소켓 연결이 끊긴다.
//			} finally {
//				//자원정리
//				try {
//					scanner.close();
//					
//					if (socket!=null && !socket.isClosed()) {
//						socket.close();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		// scanner.close();
		
	}
	
	public static void log(String message) {
		System.out.println("[Client] " + message);
	}

}
