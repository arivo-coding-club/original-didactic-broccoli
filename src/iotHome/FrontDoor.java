package iotHome;

import iotHome.IoTHome.turnable;

public class FrontDoor implements turnable {
	private boolean on;

	private boolean lock;
	
	public void turnOn() {
		on = !on;
	}
	
	public void switchLock() {
		lock = !lock;
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current LockStatus : "+lock ;
		} else {
			return "Current Status : Off";
		}
	}
}

