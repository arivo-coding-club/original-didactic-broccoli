package iotHome;

import iotHome.IoTHome.turnable;

public class Computer implements turnable {
	private boolean on;
	
	public void turnOn() {
		on = !on;
	}

	@Override
	public String toString() {
		if(on) {
			return "Current Status : On" ;
		} else {
			return "Current Status : Off";
		}
	}
}
