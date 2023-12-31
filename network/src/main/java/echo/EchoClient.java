package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {

		Socket socket = null;
		Scanner scanner = null;
		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			scanner = new Scanner(System.in);

			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				pw.println(line);
				String data = br.readLine();

				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<" + data);
			}

		} catch (SocketException e) {
			log("Suddenly closed by server : " + e);
		} catch (IOException e) {
			log("Error : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				log("Error : " + e);
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}

}
