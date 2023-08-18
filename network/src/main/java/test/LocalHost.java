package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostName = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();

			System.out.println(hostName);
			System.out.println(hostIpAddress);

			byte[] IpAddresses = inetAddress.getAddress();
			for (byte IpAddress : IpAddresses) {
				// 192.168.0.146
				// -64 -88 0 -110
				System.out.print(IpAddress+" ");
				// unsign를 만들어주는 mask
//				System.out.print((IpAddress & 0x000000ff)+" ");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
