package tv;

public class TV {
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;
	}

	public void channel(boolean up) {
		this.channel = this.channel + 1 > 255 ? 1 : this.channel + 1;
	}

	public void channel(int channel) {
		this.channel = channel;
	}

	public void volume(int volume) {
		if (volume > 100) {
			this.volume = 100;
		} else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		if(up) {
			this.volume = 0;
		}
	}

	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + ", channel=" + channel + ", volume=" + volume + "]");
	}

}
