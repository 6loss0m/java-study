package mypackage;

public class Goods2 {
	// 강하게 제어
	public String name;		// 모든 접근이 가능하다(접근 제한이 없다)
	protected int price;	// 같은 패키지 + 자식 클래스에서 접근 가능
	int countStock;			// 같은 패키지(디폴트)	
	private int countSold;	// 같은 클래스에서 접근 가능	
	// 느슨하게 제어
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void m() {
		countSold = 50;
	}
	
}
