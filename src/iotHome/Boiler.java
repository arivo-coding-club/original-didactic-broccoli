package iotHome;

import iotHome.IoTHome.*;

public class Boiler implements turnable, temperatureTurnable  {
	public boolean on;
	
	public int temperature = 30;
		
	private static final int MIN_TEMPERATURE = 20;
	
	private static final int MAX_TEMPERATURE = 45;
	
	public void turnOn() {
		on = !on;
	}

	public void turnUp() {
		if(temperature == MAX_TEMPERATURE) {
			temperature = MAX_TEMPERATURE ;
		} else {
			++temperature;
		}
	}
	
	public void turnDown() {
		if(temperature == MIN_TEMPERATURE) {
			temperature = MIN_TEMPERATURE;
		} else {
			--temperature;
		}
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current Temperature:" + temperature;
		} else {
			return "Current Status : Off";
		}
	}
}