package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] arr = new double[a.length];
		for(int i=0; i<a.length; i++) {
			arr[i] = a[i];
		}
		return arr;
	}
	
	public static int[] doubleToInt(double[] d) {
		int[] arr = new int[d.length];
		for(int i=0; i<d.length; i++) {
			arr[i] = (int)d[i];
		}
		return arr;
	}

	public static int[] concat(int[] a1, int[] a2) {
		// TODO Auto-generated method stub
		int[] arr = new int[a1.length + a2.length];
		for(int i=0; i<a1.length; i++) {
			arr[i] = a1[i];
		}
		for(int i=0; i<a2.length; i++) {
			arr[a1.length+i] = a2[i];
		}
		return arr;
		
	}

}
