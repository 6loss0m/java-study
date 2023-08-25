package chat.gui;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "192.168.0.146";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		try {
			// 1. create socket
			socket = new Socket();

			// 2. connect server
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 3. join protocol 진행
			String line = "JOIN:OK";
			if ("JOIN:OK".equals(line)) {
				printWriter.println("JOIN:" + name);
				printWriter.flush();
				new ChatWindow(name, socket).show();
			}
		} catch (SocketException e) {
			consoleLog("Suddenly closed by server : " + e);
		} catch (IOException e) {
			consoleLog("Error : " + e);
		} finally {
			// 10. 자원정리
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void consoleLog(String message) {
		System.out.println("\n[chat client]" + message);
	}
}
