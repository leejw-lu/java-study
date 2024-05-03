package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

	private BufferedReader br;
	private PrintWriter pw;
	
	private Socket socket;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name, Socket socket) {
		this.socket= socket;	//받아오기
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		try {
			this.pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream() , "utf-8"), true);
		} catch (UnsupportedEncodingException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode= e.getKeyChar();
				if (keyCode==KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);		// -> data 채팅내역 나오는 창이므로
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish(); //window창도 스레드로 열리고 있음
			}
		});
		frame.setVisible(true);
		frame.pack();

		new ChatClientThread().start(); //(내부에다 만들기)
	}
	
	private void sendMessage() {
		//textField 내역 가져오기 + 보내고 비우기
		//try {
			//pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream() , "utf-8"), true);
			String message= textField.getText();
			
			if ("quit".equals(message)) {
				finish();
			} else {
				pw.println("message:"+ message);
			}

			textField.setText("");
			textField.requestFocus();
		
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		pw.println("quit");
		System.exit(0);
	}

	// 내부에다 만드는 이유는 TextArea에 채팅내역 뿌려야 하니까 접근하기 위해서
	private class ChatClientThread extends Thread {
		
		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				String message;					
				while(true) {
					message = br.readLine();
					if (message==null) {
						break;
					}
					updateTextArea(message);
				}
			} catch (SocketException e) {
				
			} catch (IOException e) {
				
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
	}
	
	
}
