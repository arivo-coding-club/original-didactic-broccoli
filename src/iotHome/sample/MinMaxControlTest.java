package iotHome.sample;

public class MinMaxControlTest {
	public static void main(String[] args) {
		MinMaxControl heatingPad = new HeatingPad();
		
		heatingPad.setValue(HeatingPad.MAX_TEMPERATURE - 1);
		heatingPad.up(); // 이건 그냥 바뀌고 
		heatingPad.up(); // 이건 맥스라서 업 불가 
		
		MinMaxControl speaker = new Speaker();
		speaker.setValue(1); // 스피커 최소값 + 1
		speaker.down(); // 이건 다운이 되고
		speaker.down(); // 이건 미니멈이라서 다운 불가
	}
}
