package prob5;

public class MyStack{
	// 스택이 다 차면 buffer 사이즈를 2배로 늘리기
	private int top = -1;
	private String[] buffer;

//	public void print() {
//		for(String st : buffer) {
//			System.out.println(st);
//		}
//	}
	
	public MyStack(int i) {
		buffer = new String[i];
	}

	public void push(String data) {
		// resizeable 필수
		if(top==buffer.length-1) {
			String[] new_buffer = new String[buffer.length*2];
			for(int i=0; i<buffer.length; i++) {
				new_buffer[i] = buffer[i];
			}
			top++;
			new_buffer[top] = data;
			buffer = new_buffer;
			return;
		}
		top++;
		buffer[top] = data;
	}

	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	public String pop() throws MyStackException {
		if(isEmpty()) {
//			System.out.println("Exception");
			throw new MyStackException("stack is empty");
		}
		return buffer[top--];
	}
}