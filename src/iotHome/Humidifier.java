package iotHome;

import iotHome.IoTHome.*;

public class Humidifier implements turnable, timeLimitable, mutable{
	public boolean on;
	
	public boolean mute;
	
	public boolean autoTurn;
	
	public void turnOn() {
		on = !on;
	}
	
	public void autoTurnOff() {
		if(autoTurn) 
		//4시간 후 종료(테스트를 위해 4초로 설정)
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
						e.printStackTrace();
			}
	}
	
	//?값이 false로 출력되지 않고 off로 출력되는 방법
	//boolean으로 하지 않는 방법밖에 없을까
	public void mute() {
		mute = !mute;
//		if(mute) {
//			System.out.println("on");
//		} else {
//			System.out.println("off");
//		}
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current AutoTurn : "+autoTurn+", Current Mute :" + mute;
		} else {
			return "Current Status : Off";
		}
	}
	
}