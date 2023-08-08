package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=1; i<100; i++) {
			String num = String.valueOf(i);
			int count = 0;
			for(int j=0;j<num.length();j++) {
				 if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
		                count++;
		         }
			}
			if(count != 0) {
				System.out.print(i+" ");
				for(int k=0;k<count;k++) {
					System.out.print("짝");
				}
				System.out.println();
			}
			
		}
	}
}
