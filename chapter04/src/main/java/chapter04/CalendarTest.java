package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		// Calendar의 자식을 만들어서 return
		// 자식을 만들어서 return -> 팩토리 메소드
		Calendar cal = Calendar.getInstance();

		// final : 대입하는 값을 더이상 변경할 수 없음.
		// 변수앞에는 변경 불가능, 메소드 앞에는 오버라이드 불가능
		// final int i = 10;
		
		// 1. 현재 날짜 출력
		printDate(cal);

		// 2. 원하는 날의 요일 계산
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11); // 12월(month-1)
		cal.set(Calendar.DATE, 25);
		printDate(cal);

		// 3. 지정 날짜 디데이 만들기
		cal.set(2022, 8, 21);
		cal.add(Calendar.DATE, 365);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = { "일", "월", "화", "수", "목", "금", "토" };

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11. +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);

		System.out.println(year + "/" + (month + 1) + "/" + date + " " + DAYS[day - 1] + "요일 " + hours + ":" + minutes
				+ ":" + seconds);
	}

}
