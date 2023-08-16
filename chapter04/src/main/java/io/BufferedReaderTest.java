package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader br = null; // 파일을 받아오는 용도로만 가져오고, Buffered는 계속 사용하기 때문에 따로 변수로 선언
		try {
			// 기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/FileReaderTest.java");
			// 보조 스트림
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found : " + e);
		}  catch (IOException e) {
			System.out.println("File Not Found : " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
