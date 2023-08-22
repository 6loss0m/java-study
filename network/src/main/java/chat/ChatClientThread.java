package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리)
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

			while (true) {
				String message = bufferedReader.readLine();
				if (message == null) {
					break;
				}
				System.out.println(message);
			}
		} catch (SocketException e) {
			ChatClient.consoleLog("Suddenly closed by server : " + e);
		} catch (IOException e) {
			ChatClient.consoleLog("다음 이유로 프로그램을 종료 합니다 :" + e);
		} finally {
			System.exit(0);
		}
	}

}