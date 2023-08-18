package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(Binding)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("starts....[port:" + PORT + "]");

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking

			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				// 4. IO Stream 받아오기
//				PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
//				pw.print("안녕하세요");
//				pw.flush();
				// auto flush 설정
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				while (true) {
					// 5. 데이터 읽기
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}
//					IO Stram 쪽으로 넘어감.
//					String data = new String(buffer, 0, readByteCount, "UTF-8");
					
					log("received : " + data);
					pw.println(data);
				}

			} catch (IOException e) { // 데이터 통신 Stream Exception
				log("Error " + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) { // serverSocket IOException
			log("Error " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}
