package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		try {

			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				if ("exit".equals(line)) {
					break;
				}

				InetAddress[] inetAddress = InetAddress.getAllByName(line);

				for (InetAddress a : inetAddress) {
					System.out.println(a.getHostName() + " : " + a.getHostAddress());
				}
//				String hostName = inetAddress.getHostName();
//				String hostIpAddress = inetAddress.getHostAddress();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
