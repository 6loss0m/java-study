package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {
	public static void main(String[] args) {
		/*
		 * int[] a = {10, 20, 30, 40};
		 * 
		 * double[] d = ArrayUtil.intToDouble(a);
		 * System.out.println(Arrays.toString(d)); // System.out.println(d);
		 * 
		 * ArrayUtil.doubleToInt();
		 */
		double[] d= ArrayUtil.intToDouble(new int[]{10, 20, 30, 40});
		System.out.println(Arrays.toString(d));
		
		int[] a= ArrayUtil.doubleToInt(new double[]{10.0, 20.0, 30.0, 40.0});
		System.out.println(Arrays.toString(a));
		
		int[] b = ArrayUtil.concat(new int[] {1,2,3}, new int[] {4,5,6});
		System.out.println(Arrays.toString(b));
	}
}