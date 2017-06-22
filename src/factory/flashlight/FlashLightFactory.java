package factory.flashlight;

import factory.battery.BatteryFactory;

public class FlashLightFactory {
	
	public Flashlight getFlashlight() {
		return new SomeFlashlight(new BatteryFactory().getBattery());		
	}
	
}
