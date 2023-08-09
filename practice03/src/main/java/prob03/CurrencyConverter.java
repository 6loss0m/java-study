package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static void setRate(double r) {
		rate = r/1;
	}

	public static double toDollar(double d) {
		// 한국 원화를 달러로 변환
		return d*(1/rate);
	}

	public static double toKRW(double d) {
		// 달러를 한국 원화로 변환
		return d*rate;
	}

}
