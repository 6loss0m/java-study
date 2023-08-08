package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		/* 코드 작성 */
		int n = scanner.nextInt();
		int start;
		int sum = 0;
		
		if(n%2 == 0) {
			start = 2;
		}else {
			start = 1;
		}
		
		for(int i=start;i<=n;i=i+2) {
			sum += i;
		}
		System.out.println("결과 값 : "+sum);
		scanner.close();
	}
}
