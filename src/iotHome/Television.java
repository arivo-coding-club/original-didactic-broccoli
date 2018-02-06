package iotHome;

import iotHome.IoTHome.*;

public class Television implements turnable, channelSwitchable, volumnSwitchable {
	private boolean on;
	
	private int channel = 5, volumn = 5;
	
	private static final int MAX_CHANNEL = 10, MAX_VOLUMN = 10;
	
	private static final int MIN_CHANNEL = 0, MIN_VOLUMN = 0;

	public void turnOn() {
		on = !on;
	}
	
	public void channelUp() {
		if(channel==MAX_CHANNEL) {
			channel = 10;
		} else {
			++channel;
		}
	}
	
	public void channelDown() {
		if(channel==MIN_CHANNEL) {
			channel = 0;
		} else {
			++channel;
		}
	}
	
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
			return "Current Channel : "+channel +", Current Volumn :" + volumn;
		} else {
			return "Current Status : Off";
		}
	}
}
