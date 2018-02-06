package iotHome;

import iotHome.IoTHome.volumnSwitchable;

public class AirCleaner extends Humidifier implements volumnSwitchable{
	//풍량
	private int volumn = 5;
	
	private static final int MIN_VOLUMN = 0;
	
	private static final int MAX_VOLUMN = 10;
	
	public void volumnUp() {
		if(volumn==MAX_VOLUMN) {
			volumn = 10;
		} else {
			++volumn;
		}
	}
	
	public void volumnDown() {
		if(volumn==MIN_VOLUMN) {
			volumn = 0;
		} else {
			--volumn;
		}
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current AutoTurn : "+autoTurn+", Current Mute :" + mute+", Current Volumn :"+volumn ;
		} else {
			return "Current Status : Off";
		}
	}

}
