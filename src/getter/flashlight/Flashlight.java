package getter.flashlight;

import getter.battery.Battery;

public interface Flashlight {

    void swithOn();
    
    void swithOff();

    boolean isShines();

    void setBattery(Battery battery);

}
