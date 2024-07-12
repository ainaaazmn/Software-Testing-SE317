package lab5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import javax.xml.crypto.Data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HumidityTemperatureTestStyle2 {

	private int temperature;
	private int humidity;
	
	private static int pair;
	
	
	//Constructor to receive parameters
	public HumidityTemperatureTestStyle2(int temperature, int humidity) {
		
		this.temperature = temperature;
		this.humidity = humidity;
		
	}
	
	@Before
	public void setup() {
		
		pair = 0;
		HumidityTemperature.reset();
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		
		return Arrays.asList(new Object[][]{
			
			 {66, 67}, {68, 69}, {69, 70}, {67, 68}, {63, 64}, {59, 60}, {53, 54},
	         {53, 67}, {51, 63}, {48, 54}, {49, 45}, {54, 86}, {56, 76}, {56, 65}
			
		});
	}
	
	 @Test
    public void testTemperatureAndHumidity() {
		
        HumidityTemperature.roundCount++;
        
        HumidityTemperature.currentTemperature = temperature;
        HumidityTemperature.currentHumidity = humidity;

        HumidityTemperature.findTempTrend();
        HumidityTemperature.findHumidityTrend();
        HumidityTemperature.findMaxMinTemp();
        HumidityTemperature.findMaxMinHumidity();
        HumidityTemperature.humidity_Status(HumidityTemperature.currentHumidity);

        HumidityTemperature.prevTemperature = HumidityTemperature.currentTemperature;
        HumidityTemperature.prevHumidity = HumidityTemperature.currentHumidity;
		
		HumidityTemperature.displayHumidityInformation();
		HumidityTemperature.displayTemperatureInformation();

        assertEquals(temperature, HumidityTemperature.currentTemperature);
        assertEquals(humidity, HumidityTemperature.currentHumidity);
        
        assertEquals(temperature, HumidityTemperature.maxTemperature);
        assertEquals(temperature, HumidityTemperature.minTemperature);
        
        assertEquals(humidity, HumidityTemperature.maxHumidity);
        assertEquals(humidity, HumidityTemperature.minHumidity);
        
        assertEquals("Stable", HumidityTemperature.humidityTrend);
		assertEquals("Stable", HumidityTemperature.temperatureTrend);
        
    }

}
