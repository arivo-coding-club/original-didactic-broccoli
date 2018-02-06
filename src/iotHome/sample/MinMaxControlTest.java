package iotHome.sample;

public class MinMaxControlTest {
	public static void main(String[] args) {
		MinMaxControl heatingPad = new HeatingPad();
		
		heatingPad.setValue(HeatingPad.MAX_TEMPERATURE - 1);
		heatingPad.up(); // 이건 그냥 바뀌고 
		heatingPad.up(); // 이건 맥스라서 업 불가 
		
		Speaker speaker = new Speaker();
		speaker.rightUp();
		speaker.rightDown();
		speaker.leftUp();
		speaker.leftDown();
	}
}
