package getter.flashlight;

import getter.battery.Battery;

public class SomeFlashlight implements Flashlight {

    private Battery battery;
    private boolean swithOn;
    
    public SomeFlashlight() {
        this.swithOn = false;
    }
    
    public void setBattery(Battery battery) {
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
