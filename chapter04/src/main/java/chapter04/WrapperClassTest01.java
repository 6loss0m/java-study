package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하게 되면 JVM의 힙상에 객체가 존재하게 된다.
		// 리터럴을 사용하게 되면 JVM 안의 Constant Poll이 관리한다.
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);

		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 20;

		System.out.println(j1 == j2); 	// referencec값을 비교 하기 때문에 false.
		System.out.println(j1 < j2); 	// 실제 존재하는 값을 비교 -> Auto unBoxing이 해줌.
		
		// Auto Unboxing
		// int m = j1.intValue() + 10;	
		int m = j1 + 10;
		
	} 

}
