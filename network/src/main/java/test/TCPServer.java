package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			//1. Server Socket 생성
			serverSocket= new ServerSocket();
			
			//1-1. FIN_WAIT2 -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위해
			serverSocket.setReuseAddress(true);
			
			//2. 바인딩(binding) 바인딩 소켓에 주소를 바인딩 시킨다. 
			//	Socket에 InetSocketAddress[InetAddress(IPAddress) + Port]를 바인딩 한다.
			//	IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다.
			//	10은 연결 큐 길이
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);	//> ""에 특정ip 지정하는 것은 좋진 않음. 클라가 여기로만 들어와야하니까
			
			//3. Accept
			Socket socket= serverSocket.accept();	// blocking
			try {
				InetSocketAddress inetRemoteSocketAddress= (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort+ "]");
				
				//4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					System.out.println("try to read");
					//5. 데이터 읽기
					byte[] buffer= new byte[256];
					int readByteCount = is.read(buffer);	//blocking
					
					if (readByteCount == -1) {
						// closed by client
						System.out.println("[server] closed by client");
						break;
					}
					String data= new String(buffer, 0, readByteCount, "UTF-8");	//inputStreamReader에 맡긴다.
					System.out.println("[server] received:" + data);
					
					//6. 데이터 쓰기
					//SO_TIMEOUT 테스트
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					os.write(data.getBytes("utf-8"));
					
				}
				
			} catch(SocketException e) {
				System.out.println("[server] Socket Exception" + e);
			} catch(IOException e) {
				System.out.println("[server] error: "+ e);
			} finally {
				try {
					if (socket!=null && !socket.isClosed()) {
						socket.close();
					}

				} catch(IOException e) {
					e.printStackTrace();
				}

			} 
			
			
		} catch (IOException e) {
			System.out.println("[server] error: "+ e);
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

}
