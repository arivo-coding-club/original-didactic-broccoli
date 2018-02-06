package iotHome;

import iotHome.IoTHome.*;

public class DishWasher implements turnable, pause {
	public boolean on;

	private boolean pause;
	
	public void turnOn() {
		on = !on;
	}

	public void pause() {
		pause = !pause;
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current Status: "+pause;
		} else {
			return "Current Status : Off";
		}
	}
}