package iotHome.sample;

public class Speaker {
	private SizeControl rightVolume = new SizeControl(10, 0, 100);
	
	private SizeControl leftVolume = new SizeControl(10, 0, 100);
	
	public int rightUp() {
		return rightVolume.up();
	}
	
	public int rightDown() {
		return rightVolume.down();
	}
	
	public int leftUp() {
		return leftVolume.up();
	}
	
	public int leftDown() {
		return leftVolume.down();
	}
}
