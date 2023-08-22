package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();

			// 1-1. FIN-WAIT -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위해....
			serverSocket.setReuseAddress(true);
			
			
			// 2. 바인딩(Binding)
			// 내가 accept를 받을 수 이는 ip
			// Socket에 InetSocketAddress(IPAddress + port)를 바인딩 한다.
			// IPAddress : 0.0.0.0 : 특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); // TCP/TP서버가 loop back 하지않게 설정

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking
			// 연결을 기다리는 상태

			try {
				// InetAddress(부모) <--> InetSocketAddress(자식)
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				// 4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking

					if (readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}

					// buffer을 0부터 readByteCount까지 UTF-8로 인코딩하여 String으로 변환
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received : " + data);
					
					// SO_TIMEOUT 옵션 테스트용
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					
					//6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			} catch (IOException e) { // 데이터 통신 Stream Exception
				System.out.println("[server] Error " + e);
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
			System.out.println("[server] Error " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				} // null이 아니고, 닫혀있지 않다면, socket close
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
