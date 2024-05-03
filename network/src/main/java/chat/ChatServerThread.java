package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	//run 구현하기
	private String nickname;
	private Socket socket;
	
	private List<Writer> listWriters;
	
	BufferedReader br =null;
	PrintWriter pw =null;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket=socket;
		this.listWriters= listWriters;
	}
	
	@Override
	public void run() {
		try {
			//1. Remote Host Information
			InetSocketAddress inetRemoteSocketAddress= (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			
			//2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream() , "utf-8"), true);	//auto 플러시 true
			
			//3. 요청 처리
			while(true) {
				String request= br.readLine();		//blocking		
				
				if (request==null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				//4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals((tokens[0]))) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break; //추가
				} else {
					ChatServer.log("에러: 알수없는 요청(" + tokens[0]+ ")" );
				}
			
			}
			
		} catch(SocketException e) {
			ChatServer.log("Socket Exception: " + e);		//000님이 퇴장하였습니다.
			doQuit(pw);
		} catch(IOException e) {
			ChatServer.log("error: "+ e);
		} finally {
			try {
				if (socket!=null && !socket.isClosed()) {
					socket.close();
				}

			} catch(IOException e) {
				e.printStackTrace();
			}

		} 
	}
	

	private void doJoin(String nickName, Writer writer) {
		this.nickname=nickName;
		
		String data= nickName+"님이 참여하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장*/
		addWriter(writer);
		
		// ack
		pw.println("join:ok");
	}

	// 서버에 연결된 모든 client에게 메시지를 보낸다.
	private void broadcast(String data) {
		synchronized(listWriters) {
			for (Writer writer: listWriters) {
				PrintWriter printWriter= (PrintWriter) writer;
				printWriter.println(data);	//client로 전송
				printWriter.flush();
			}
		}
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}

	private void doMessage(String data) {
		broadcast(nickname+":"+data);
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data= nickname+ "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		// 현재 스레드의 writer를 Write Pool에서 제거한 후, 브로드캐스팅 한다.
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}
	
}
