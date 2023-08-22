package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerTread extends Thread {

	private String nickname = "Guest";
	private Socket socket;
	private List<Writer> listWriters;

	public ChatServerTread(Socket socket) {
		this.socket = socket;
	}

	public ChatServerTread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			// 1. Remote Host Information
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			// 2. 스트림 얻기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();
				// if (request == null) {
				// log("클라이언트로 부터 연결 끊김");
				// break;
				// }
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
					break;
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}
		} catch (IOException e) {
			log("error : " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			log("error : " + e);
			log(" 닉네임 또는 메시지를 입력해주세요.");
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다.";
//		log(data);
		broadcast(data);
	}

	private void doMessage(String message) {
		/* 잘 구현 해 보기 */
		String data = "[" + nickname + "] : " + message;
		broadcast(data);
//		log(data);
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(writer);

		// ack
		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.println(data);
		printWriter.flush();
		log(data);
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void broadcast(String data) {

		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}

		}

	}

	private void log(String message) {
		System.out.println("[" + nickname + "] : " + message);
	}
}