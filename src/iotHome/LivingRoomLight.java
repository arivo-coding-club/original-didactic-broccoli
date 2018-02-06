package iotHome;

import iotHome.IoTHome.turnable;

public class LivingRoomLight extends Light implements turnable {
	private boolean on;
	
	public void turnOn() {
		on = !on;
	}
	
	void lightUp() {
		if(light == MAX_LIGHT) {
			light = MAX_LIGHT;
		} else {
			++light;
		}
	}
	
	void lightDown() {
		if(light == MIN_LIGHT) {
			light = MIN_LIGHT;
		} else {
			--light;
		}
	}
	
	
	@Override
	public String toString() {
		if(on) {
			return "Current light : "+light;
		} else {
			return "Current Status : Off";
		}
	}

}
