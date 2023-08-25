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
import java.nio.charset.StandardCharsets;

import chat.ChatClient;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend,buttonQuit;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	
	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		buttonQuit = new Button("Quit");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
//				System.out.println("Button Click");
				sendMessage();
			}
		});
		
		buttonQuit.setBackground(Color.GRAY);
		buttonQuit.setForeground(Color.WHITE);
		buttonQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				finish();
			}
		});		
		
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		pannel.add(buttonQuit);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
//				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		// ChatClientThread 생성하고 실행
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			new ChatClientThread(socket).run();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void finish() {
		// quit 프로토콜 구현
		quit();
		// exit java(JVM)
		System.exit(0);
	}
	
	private void quit() {
		printWriter.println("QUIT");
	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메시지를 보내는 프로토콜 구현 : " + message);

		textField.setText("");
		textField.requestFocus();

		if(message.equals("QUIT")) {
			finish();
		}
		
		printWriter.println("MESSAGE:"+message);
//		printWriter.flush();
		// ChatClientThread 에서 서버로 부터 받은 메시지가 있다고 치고~~
//		updateTextArea("마이콜 : " + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		private BufferedReader bufferedReader;
		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {

			try {
				bufferedReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {

					String message = bufferedReader.readLine();
					if (message == null) {
						break;
					}
					updateTextArea(message);
				}
			} catch (SocketException e) {
				ChatClient.consoleLog("Suddenly closed by server : " + e);
			} catch (IOException e) {
				ChatClient.consoleLog("다음 이유로 프로그램을 종료 합니다 :" + e);
			} finally {
				System.exit(0);
			}
		}
//		updateTextArea("마이콜 : 안녕~");
	}
}
