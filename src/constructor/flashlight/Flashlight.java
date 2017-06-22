package constructor.flashlight;

public interface Flashlight {
// Фонарик может включаться (switchOn) и выключаться (switchOff) а светится он или нет, мы узнаем с помощью метода isShines, возвращающего true/false.
	void switchOn();
	
	void switchOff();

	boolean isShines();

}
