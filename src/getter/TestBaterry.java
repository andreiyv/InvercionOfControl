package getter;
import static org.junit.Assert.*;
import getter.battery.Battery;
import getter.battery.ChinaBattery;
import getter.flashlight.Flashlight;
import getter.flashlight.SomeFlashlight;

import org.junit.Test;

public class TestBaterry {
        
    class DisposableBattery implements Battery{

        private boolean full = true;
        
        @Override
        public boolean getVoltage() {            
            if (full) {
                full = false;
                return true;
            }
            return false;
        }
    }
    
    @Test
    public void testDischargeNewBattery() {                        
        Battery battery = new DisposableBattery();
        
        Flashlight flashlight = new SomeFlashlight();
        flashlight.setBattery(battery);
        
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());
        
        flashlight.swithOff();        
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();        
        assertFalse(flashlight.isShines());        
    }
    
    @Test
    public void testChangeDischargedBattery() {                        
        Battery battery = new DisposableBattery();
        
        Flashlight flashlight = new SomeFlashlight();
        flashlight.setBattery(battery);
        
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());
        
        flashlight.swithOff();        
        assertFalse(flashlight.isShines());
        
        flashlight.setBattery(new DisposableBattery());
        
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());        
    }
    
    @Test
    public void testBadBattery() {                        
        Battery battery = new Battery(){
            @Override
            public boolean getVoltage() {            
                return false;
            }
        };
        
        Flashlight flashlight = new SomeFlashlight();        
        flashlight.setBattery(battery);
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();        
        assertFalse(flashlight.isShines());            
    }
    
    @Test
    public void testNoGetPowerIfDoubleSwithOn() {                        
        Battery battery = new DisposableBattery();
        
        Flashlight flashlight = new SomeFlashlight();
        flashlight.setBattery(battery);
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());
        
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());            
    }
            
    @Test 
    public void testNoBatteryNoLight() {        
        Flashlight flashlight = new SomeFlashlight();
        
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();
        
        assertFalse(flashlight.isShines());    
    }
    
    @Test 
    public void testRemoveBatteryFromFlashlightDurringLightOn() {        
        Battery battery = new DisposableBattery();
        
        Flashlight flashlight = new SomeFlashlight();
        flashlight.setBattery(battery);
                
        flashlight.swithOn();        
        assertTrue(flashlight.isShines());
        
        flashlight.setBattery(null);
        assertFalse(flashlight.isShines());
    }
    
    @Test
    public void integrationTestGetPowerFormNewChinaBattery() {                
        Battery battery = new ChinaBattery();
        
        Flashlight flashlight = new SomeFlashlight();
        flashlight.setBattery(battery);
        
        assertFalse(flashlight.isShines());
        
        flashlight.swithOn();
        
        assertTrue(flashlight.isShines());    
    }
    
}
