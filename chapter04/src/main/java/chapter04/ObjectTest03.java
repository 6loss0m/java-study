package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");

		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));

		/*
		 *  hashCode 메소드는 객체에 대한 해시 코드 값을 반환하는 메소드입니다.
		 *  String 클래스의 경우, hashCode 메소드는 문자열의 내용을 기반으로 해시 코드를 계산합니다.
		 *  따라서 내용이 같은 두 문자열은 동일한 해시 코드 값을 가집니다.
		 */
		
		System.out.println("================================");

		String s3 = "hello";
		String s4 = "hello";

		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
	}

}
