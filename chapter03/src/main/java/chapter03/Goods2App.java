package chapter03;

import mypackage.Goods2;

public class Goods2App{

	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		//	public
		goods.name = "camera";
		//	protected : 같은 패키지에서 접근이 가능하다.(오류)
		//				더 중요한 접근 제어는 자식에서 접근 가능하다.
		//goods.price = 500000;
		// 	default
		//goods.countStock = 30;
		//	private
		//같은 클래스에서만 접근이 가능하다.
//		goods.countSold = 10;
		
	}

}
