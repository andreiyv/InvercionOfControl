package factory.battery;

public class BatteryFactory {
	
	public Battery getBattery() {
		return new ChinaBattery();		
	}
	
}
