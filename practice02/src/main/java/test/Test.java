package test;

public class Test {

	public static void main(String[] args) {
		int[] num_list = { 4, 2, 6, 1, 7, 6 };
		int n = 4;
		
		int flag = ((num_list.length % n) != 0) ? 1 : 0;

		int[] answer = new int[(num_list.length / n) + flag];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num_list[i * n];
		}
	}

}
