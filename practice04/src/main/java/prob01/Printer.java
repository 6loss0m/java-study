package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//	}
//
//	public void println(String string) {
//		System.out.println(string);
//	}

	public <T> void println(T t) {
		System.out.println(t);
	}
//	완전 동일	
//	public void println(Object o) {
//		System.out.println(o);
//	}

	public int sum(Integer... nums) {
			int s= 0;
			for(Integer i : nums) {
				s += i;
			}
			return s;
	}
}
