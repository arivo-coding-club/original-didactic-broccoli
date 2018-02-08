package iotHome;

import iotHome.IoTHome.turnable;

public class RiceCooker implements turnable {
	private boolean on;
	
	private int cookButton = 0;
	private String[] statusMessage = {"Waiting", "PowerOn", "Keeping", "Cooking"};
	
	//toggle(번갈아서 상태가 움직이는 것)
	//의미에 맞춘 메서드 이름을 갖기
	//arraylist의 add처럼 다른 사람이 의미 몰라도 사용할 수 있도록!!
	public void turnOn() {
		on = !on;
	}
	
	public void printStatus() {
		System.out.println(toString());
	}
	
	public String getStatusMessage() {
		if(on) {
				return statusMessage[cookButton];
			} 		
			return "OFF";
	}
	
	public void turnUp() {
		if(!(cookButton==statusMessage.length-1)) {
			cookButton++;
		}
	}
	
		
	
	public void turnDown() {
		if(cookButton==0) {
			System.out.println("MIN");
		} else {
			cookButton--;
		}
	}
		
	
	@Override
	// 이 객체를 문자열로 바꾼다면 어떻게 될까?라는 뜻임
	//toString은 내용만 보여주도록 해야 사용자가 예상한 대로 작동함
	public String toString() {
		//return "Current Status: " + getStatusMessage();
		return "Current Status: " + getStatusMessage() + ", cookButton: " + cookButton;
	} 
}	

