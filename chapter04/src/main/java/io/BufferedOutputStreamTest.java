package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null; // 파일을 받아오는 용도로만 가져오고, Buffered는 계속 사용하기 때문에 따로 변수로 선언
		try {
			// 기반 스트림
			FileOutputStream fis = new FileOutputStream("hello.txt"); // 파일이 꽉차면 exception 발생 가능

			// 보조 스트림
			bos = new BufferedOutputStream(fis);

			// for (int i = 'a'; i <= 'z'; i++)
			for(int i = 97; i <= 122; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		}  finally {
			try {
				if (bos != null) {

					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
