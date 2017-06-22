package constructor.flashlight;

import constructor.battery.Battery;

public class SomeFlashlight implements Flashlight {

	private Battery battery;
	private boolean switchOn;
	
	public SomeFlashlight(Battery battery) {
// Конструктор фонарика мило подставит любую батарейку (которая, implements Battery) в свое поле.
// Это позволит в дальнейшем пользоваться из фонарика всеми методами, объявленными в интерфейсе Battery
		this.battery = battery;
		this.switchOn = false;
	}

	@Override
//  свет горит (isShines = true) только, если батарейка есть + если она дает заряд
	public boolean isShines() {
		return (battery != null) && switchOn;
	}

	@Override
	public void switchOn() {
// Фонарик при включении (switchOn()) попросит у батарейки энергии (battery.getVoltage()).
// Вообще, так это полиморфизм на интерфейсах - результат выполнения battery.getVoltage() будет зависеть от того, что находится в battery.
		if (!switchOn && battery != null) {
			switchOn = battery.getVoltage();
		}			
	}

	@Override
	public void switchOff() {
		switchOn = false;
	}

}
