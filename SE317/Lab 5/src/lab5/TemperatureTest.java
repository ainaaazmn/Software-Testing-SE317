package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TemperatureTest {

	@Before
	public void setup() {
		HumidityTemperature.reset();
	}
	
	//Test cases for current temperature
	@Test
	public void testReceiveCurrentTemperature() {
		
		HumidityTemperature.currentTemperature = 98;
		
		assertEquals(98, HumidityTemperature.currentTemperature);
	}
	
	@Test
	public void testTemperatureUpperBoundaryFalse() {
		
		HumidityTemperature.currentTemperature = 1000;
		
		assertEquals(false, HumidityTemperature.isValidTemperature(HumidityTemperature.currentTemperature));
	}

	@Test
	public void TestTemperatureLowerBoundaryFalse() {
		
		HumidityTemperature.currentTemperature = -34;
		
		assertEquals(false, HumidityTemperature.isValidTemperature(HumidityTemperature.currentTemperature));
	}
	
	@Test
	public void TestTemperatureUpperBoundaryCorrect() {
		
		HumidityTemperature.currentTemperature = 150;
		
		assertEquals(true, HumidityTemperature.isValidTemperature(HumidityTemperature.currentTemperature));
	}


	@Test
	public void TestTemperatureLowerBoundaryCorrect() {
		
		HumidityTemperature.currentTemperature = 0;
		
		assertEquals(true, HumidityTemperature.isValidTemperature(HumidityTemperature.currentTemperature));
	}

	
	//Test cases for maximum temperature
	@Test
	public void testUpdateMaximumTemperature() {
		
		HumidityTemperature.maxTemperature = 67;
		HumidityTemperature.currentTemperature = 98;
		
		HumidityTemperature.findMaxMinTemp();
		
		assertEquals(98, HumidityTemperature.maxTemperature);
		 
	}
	
	@Test
	public void testMaintainMaximumTemperature() {
		
		HumidityTemperature.maxTemperature = 107;
		HumidityTemperature.prevTemperature = 56;
		HumidityTemperature.currentTemperature = 98;
		
		HumidityTemperature.findMaxMinTemp();
		
		assertEquals(107, HumidityTemperature.maxTemperature);
		 
	}
	
	//Test cases for minimum temperature
	@Test
	public void testUpdateMinimumTemperature() {
		
		HumidityTemperature.minTemperature = 67;
		HumidityTemperature.currentTemperature = 56;
		
		HumidityTemperature.findMaxMinTemp();
		
		assertEquals(56, HumidityTemperature.minTemperature);
	}
	
	@Test
	public void testMaintainMinimumTemperature() {
		
		HumidityTemperature.minTemperature = 98;
		HumidityTemperature.prevTemperature = 115;
		HumidityTemperature.currentTemperature = 107;
		
		HumidityTemperature.findMaxMinTemp();
		
		assertEquals(98, HumidityTemperature.minTemperature);
		
	}
	
	//Test cases for temperature trend
	@Test
	public void testTemperatureTrendUp() {
		
		HumidityTemperature.prevTemperature = 45;
		HumidityTemperature.currentTemperature = 50;
		
		HumidityTemperature.findTempTrend();
		
		assertEquals("Increasing", HumidityTemperature.temperatureTrend);
	}
	
	@Test
	public void testTemperatureTrendDown() {
		
		HumidityTemperature.prevTemperature = 45;
		HumidityTemperature.currentTemperature = 40;
		
		HumidityTemperature.findTempTrend();
		
		assertEquals("Decreasing", HumidityTemperature.temperatureTrend);
	}
	
	@Test
	public void testTemperatureTrendStable() {
		
		HumidityTemperature.prevTemperature = 45;
		HumidityTemperature.currentTemperature = 45;
		
		HumidityTemperature.findTempTrend();
		
		assertEquals("Stable", HumidityTemperature.temperatureTrend);
	}
}
