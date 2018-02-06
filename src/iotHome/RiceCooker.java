package iotHome;

import iotHome.IoTHome.turnable;

public class RiceCooker implements turnable {
	private boolean on;
	
	private int cookButton = 0;
	
	private static final int MIN_COOKBUTTON = 0;
	private static final int MAX_COOKBUTTON= 3;
	
	public void turnOn() {
		on = !on;
	}
	
	public void turnUp() {
		if(cookButton == MAX_COOKBUTTON) {
			cookButton = MAX_COOKBUTTON ;
		} else {
			cookButton++;
		} 
	}
	
	public void turnDown() {
		if(cookButton == MIN_COOKBUTTON) {
			cookButton = MIN_COOKBUTTON ;
		} else {
			cookButton++;
		}
	}
	
	//turnOn을 해도 cook이 실행되지 않음
	public void cook(int cookButton) {
		if(cookButton == 0) {
		} else if(cookButton == 1) {
			System.out.println("PowerOn");
		} else if(cookButton == 2) {
			System.out.println("Keeping");
		} else {
			System.out.println("Cooking");
		}
	}
	
	
	
	@Override
	public String toString() {
		cook(cookButton);
		if(on) {
			return "Current cook : ";
		} else {
			return "Current Status : Off";
		}
	}
}
