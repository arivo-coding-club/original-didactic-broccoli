package iotHome.sample;

public class Speaker {
	//has a 관계로 만듦
	//구성하는 방식
	//effective java에서 추천하는 방식
	private SizeControl rightVolume = new SizeControl(10, 0, 100);
	
	private SizeControl leftVolume = new SizeControl(10, 0, 100);
	
	//밖에서는 이런 public만 보임 
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
