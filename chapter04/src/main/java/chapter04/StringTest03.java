package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + " World" + "Java";

//		StringBuffer sb = new StringBuffer("Hello");
//		sb.append("World");
//		sb.append("java");
//		sb.append(17);
//		String s1 = sb.toString();

		String s1 = new StringBuffer("Hello")
						.append("World")
						.append("java")
						.append(17)
						.toString();

		System.out.println(s1);

		String s2 = "";
		for (int i = 0; i < 100000; i++) {
			// s2 = s2 + i; 같은 원리 -> new는 메모리에 객체 생성하는게 시간이 오래 걸림.
			// s2 = new StringBuffer(s2).append(i).toString();
		}
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<100000; i++) {
			sb.append(i);
		}
		String s3 = sb.toString();
		
		// String method들...
		String s4 = "aBcABCabcAbc";
		
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3)); // 3번쨰 부터 출력
		System.out.println(s4.substring(3,5)); // 3 ~ 4까지 출력
		
		String s5 = "   ab    cd   ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
	
		// trim() : 양쪽의 공백을 없앰.
		System.out.println("---"+s5.trim()+"---");
		System.out.println("---"+s5.replaceAll(" ", "")+"---");
		
		// split() : 배열로 반환
		String[] tokens = s6.split(",");
		for(String token : tokens) {
			System.out.println(token);
		}
		
		String[] tokens2 = s6.split(" ");	// 구분자가 없으면, 원본 String을 첫 번쨰 배열에 저장
		for(String token : tokens2) {
			System.out.println(token);
		}
		
	}

}