package constructor.flashlight;

public interface Flashlight {
// Фонарик может включаться (swithOn) и выключаться (swithOff) а светится он или нет, мы узнаем с помощью метода isShines, возвращающего true/false.
	void swithOn();
	
	void swithOff();

	boolean isShines();

}
