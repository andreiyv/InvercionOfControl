package factory.flashlight;

import factory.battery.Battery;

class SomeFlashlight implements Flashlight {

	private Battery battery;
	private boolean swithOn;
	
	public SomeFlashlight(Battery battery) {
		this.swithOn = false;
		this.battery = battery;
	}
	
	@Override
	public boolean isShines() {
		return (battery != null) && swithOn;
	}

	@Override
	public void swithOn() {
		if (!swithOn && battery != null) {
			swithOn = battery.getVoltage();			 
		}			
	}

	@Override
	public void swithOff() {
		swithOn = false;
	}

}
