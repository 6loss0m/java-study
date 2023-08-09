package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String answer = "";
		for(String st : strArr) {
			answer += st;
		}
		return answer;
	}
}
