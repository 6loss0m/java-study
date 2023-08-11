package singleton;

public class SingletonTest {
	public static void main(String[] args) {
		// 팩토리 메소드는 Singleton을 위한것

		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();

		System.out.println(singleton1 == singleton2);

	}
}