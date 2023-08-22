package chat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.146";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			consoleLog("connected");

			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 5. join 프로토콜
//			while (true) {
			System.out.print("닉네임(공백 불가능)>>");
			String nickname = scanner.nextLine();

//				System.out.println("name : " + nickname + ",length" + nickname.length());
			if (!validateName(nickname)) {
				nickname = "Guest";
			}
			printWriter.println("join:" + nickname);
			printWriter.flush();
//				break;
//				consoleLog("올바르지 않는 형식의 닉네임 입니다.");
//			}

			// 6. ChatClientReceiveThread 시작

			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input)) {
					// 8. quit 프로토콜 처리
					printWriter.println("quit");
					break;
				} else {
					// 9. 메시지 처리
					printWriter.println("message:" + input);
				}
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

	public static boolean validateName(String nickname) {
		if (nickname == null) {
			return false;
		}
		if (nickname.length() == 0) {
			return false;
		}
		if (nickname.trim().replace(" ", "").length() == 0) {
			System.out.println(nickname);
			return false;
		}
		return true;
	}

	public static void consoleLog(String message) {
		System.out.println("\n[chat client]" + message);
	}
}