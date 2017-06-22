package constructor.flashlight;

import constructor.battery.Battery;

public class SomeFlashlight implements Flashlight {

	private Battery battery;
	private boolean swithOn;
	
	public SomeFlashlight(Battery battery) {
// Конструктор фонарика мило подставит любую батарейку (которая, implements Battery) в свое поле.
// Это позволит в дальнейшем пользоваться из фонарика всеми методами, объявленными в интерфейсе Battery
		this.battery = battery;
		this.swithOn = false;
	}

	@Override
//  свет горит (isShines = true) только, если батарейка есть + если она дает заряд
	public boolean isShines() {
		return (battery != null) && swithOn;
	}

	@Override
	public void swithOn() {
// Фонарик при включении (swithOn()) попросит у батарейки энергии (battery.getVoltage()).
// Вообще, так это полиморфизм на интерфейсах - результат выполнения battery.getVoltage() будет зависеть от того, что находится в battery.
		if (!swithOn && battery != null) {
			swithOn = battery.getVoltage();			 
		}			
	}

	@Override
	public void swithOff() {
		swithOn = false;
	}

}
