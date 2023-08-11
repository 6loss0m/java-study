package prob2;

public class SmartPhone extends MusicPhon {

	@Override
	public void execute(String app) {
		if(app.equals("앱")) {
			app();
			return;
		}
		super.execute(app);
	}

	private void app() {
		System.out.println("스마트폰에서 앱 실행");
	}
	
	
}
