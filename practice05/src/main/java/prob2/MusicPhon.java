package prob2;

public class MusicPhon extends Phone {
	@Override
	public void execute(String function) {
		if (function.endsWith("음악")) {
			playMusic();
			return;
		}
		super.execute(function);
	}

	private void playMusic() {
		System.out.println("MP3 플레이어에서 음악재생");
	}
}
