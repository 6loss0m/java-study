package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		// 자료구조는 무조건 동질성 테스트 후 입력
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		
		s.add(s1);
		//s.add(s2);

		System.out.println(s.size());
		System.out.println(s.contains(s2));	// 값 기반
		
		// index가 없기 때문에 순회 밖에 할 수 없음.
		// 순회
		for (String str : s) {
			System.out.println(str);
		}

	}

}
