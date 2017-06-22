package constructor.battery;

public class ChinaBattery implements Battery {
// батарейка разряжается от последовательных вызовов ее метода getVoltage
	private int power = 5; 
	
	@Override
	public boolean getVoltage() {
		if (power > 0) {
			power--;
			return true;
		}
		
		return false;
	}

}
