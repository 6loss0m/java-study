package chapter04;

import java.util.Objects;

public class Rect {
	private int width;
	private int height;

	public Rect(int width, int hegith) {
		this.width = width;
		this.height = hegith;
	}

	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return height == other.height && width == other.width;
	}

	
	
// 비즈니스에 따라 hashCode, equals를 변경하는 코드
//	@Override
//	public int hashCode() {
//		return Objects.hash(height*width);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Rect other = (Rect) obj;
//		return height*height == other.height*other.width;
//	}
	
	
}
