package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
	
		Goods camera = new Goods();	//오른쪽 부터 실행 Goods 객체 생성, 후 참조 변수 camera에 assign
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountStock(30);
		camera.setCountSold(50);
		
		// 정보은닉(데이터보호)
		//camera.setPrice(-1);
		
		// countOfGoods 테스트
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();

		System.out.println(Goods.countOfGoods);

		camera.showInfo();
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println(discountPrice);
	}
}