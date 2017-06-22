package factory;
import static org.junit.Assert.*;

import org.junit.Test;

import factory.flashlight.FlashLightFactory;
import factory.flashlight.Flashlight;

public class TestBaterry {
			
	@Test
	public void testDischargeNewBattery() {								
		Flashlight flashlight = new FlashLightFactory().getFlashlight();		
		assertFalse(flashlight.isShines());
		
		flashlight.swithOn();		
		assertTrue(flashlight.isShines());
		
		for (int count = 0; count < 1000; count ++) {
			flashlight.swithOff();							
			flashlight.swithOn();					
		}
		
		flashlight.swithOn();
		assertFalse(flashlight.isShines());		
	}
		
	@Test
	public void testNoGetPowerIfDoubleSwithOn() {						
		Flashlight flashlight = new FlashLightFactory().getFlashlight();	
		assertFalse(flashlight.isShines());
		
		for (int count = 0; count < 1000; count ++) {					
			flashlight.swithOn();					
		}
		
		assertTrue(flashlight.isShines());			
	}	

	@Test
	public void integrationTestGetPowerFormNewChinaBattery() {				
		Flashlight flashlight = new FlashLightFactory().getFlashlight();	
		
		assertFalse(flashlight.isShines());
		
		flashlight.swithOn();
		
		assertTrue(flashlight.isShines());	
	}
	
}
