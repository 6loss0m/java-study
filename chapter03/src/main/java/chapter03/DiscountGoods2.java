package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2{
	private float discountRate = 0.5F;
	
	public int getDiscountPrice() {
		return (int)(discountRate * price);
	}
	

}
