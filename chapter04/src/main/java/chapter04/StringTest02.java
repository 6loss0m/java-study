package chapter04;

import java.io.FileInputStream;

public class StringTest02 {

	public static void main(String[] args) {
		// 불변성(immutability)
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;

		s2 = s1.toUpperCase();
		/*
		 * "abc"객체 안에 toUpperCase()라는 메소드가 존재. s2가 "def"를 참조하고 있다가 "ABC"로 만들어낸 새로운 객체에
		 * assign하고 사라짐.
		 */
		String s4 = s2.concat("??");
		/*
		 * concat실행시 "??"라는 string생성, 그리고 나서 코드 실행시 str해서 객체를 새로 만듬 "ABC??" return str
		 * 해서 반환한 값을 s4가 받고, 스택에서 나옴. 참조하던 "??" reference객체 사라짐.
		 */
		String s5 = "!".concat(s2).concat("@");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);

		System.out.println(equalsHello("Hello"));
		// 1번처럼 메소드를 작성하면 null일 들어갈 때 nullPointException발생 가능
		// 안전하게 코드를 작성해야함!
		System.out.println(equalsHello(null));
	}

	private static boolean equalsHello(String s) {
		// 1. return s.equals("Hello");
		return "Hello".equals(s);
	}
}
