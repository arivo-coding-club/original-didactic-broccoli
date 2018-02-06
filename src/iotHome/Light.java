package iotHome;


public abstract class Light{
	public int light= 5;
	
	public static final int MAX_LIGHT = 10;
	
	public static final int MIN_LIGHT = 0;
	
	abstract void lightUp();
	
	abstract void lightDown();
	
	
}