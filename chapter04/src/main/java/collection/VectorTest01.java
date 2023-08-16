package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();

		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");

		// 순회1
		for (int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v.removeElementAt(2);
		
		// 순회2 - index를 직접 선언하지 않고 collection객체에게 달라고 하기.
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		} // -> 한번 사용했기 때문에 더이상 사용 못함
		
	}

}
