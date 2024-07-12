package lab5;

import java.util.*;

public class HumidityTemperature {
	
	//Constants
	protected static final int MIN_HUMIDITY = 0;
	protected static final int MAX_HUMIDITY = 100;
	
	protected static final int MIN_TEMPERATURE = 0;
	protected static final int MAX_TEMPERATURE = 150;
	
	protected static final int LOW_HUMIDITY = 25;
	protected static final int HIGH_HUMIDITY = 55;
	
	protected static final long FIVE_MINS_IN_MILLISECONDS = 300000;
	protected static final long SIMULATION_INTERVAL = 20000; //For testing purposes
	
	//Variable for readings
	protected static int currentTemperature;
	protected static int currentHumidity;
	
	protected static int prevTemperature;
	protected static int prevHumidity;
	
	protected static String humidityStatus;
	
	protected static int maxHumidity;
	protected static int minHumidity;
	
	protected static int maxTemperature;
	protected static int minTemperature;
	
	protected static String temperatureTrend;
	protected static String humidityTrend;
	
	protected static int roundCount;
	
	public static void main(String[] args) {
		
		reset();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
	
		System.out.println("Enter current humidity percentage: ");
		currentHumidity = scanner.nextInt();
			
		while(!isValidHumidity(currentHumidity)) {
			
			System.out.println("Invalid humidity percentage value. Please enter a value between " + MIN_HUMIDITY + "-" + MAX_HUMIDITY);
			
			System.out.println("Enter current humidity percentage: ");
			currentHumidity = scanner.nextInt();
			
			}
		
		System.out.println("Enter current temperature(F): ");
		currentTemperature = scanner.nextInt();
		
		while(!isValidTemperature(currentTemperature)) {
			
			System.out.println("Invalid temperature value. Please enter a value between " + MIN_TEMPERATURE + "-" + MAX_TEMPERATURE);
			
			System.out.println("Enter current temperature(F): ");
			currentTemperature = scanner.nextInt();
			
			}
			
		
		try {
	
			roundCount++;
			
			findTempTrend();
			findHumidityTrend();
			
			findMaxMinTemp();
			findMaxMinHumidity();
			
			humidity_Status(currentHumidity);
			
			displayHumidityInformation();
			displayTemperatureInformation();
			
			Thread.sleep(SIMULATION_INTERVAL);
			
			prevTemperature = currentTemperature;
			prevHumidity = currentHumidity;
			
		} catch(InterruptedException e) {
			System.err.println("Sleep is interrupted" + e.getLocalizedMessage());
			}
		
		}
	}
	
	public static boolean isValidHumidity(int inputHumidity) {
		
		return (inputHumidity >= MIN_HUMIDITY) && (inputHumidity <= MAX_HUMIDITY);
		
	}
	
	public static boolean isValidTemperature(int inputTemperature) {
		
		return (inputTemperature >= MIN_TEMPERATURE) && (inputTemperature <= MAX_TEMPERATURE);
		
	}
	
	public static void findTempTrend() {
		
		if(roundCount != 1) {
			
			if(currentTemperature > prevTemperature)
				temperatureTrend = "Increasing";
			
			else if(currentTemperature < prevTemperature)
				temperatureTrend = "Decreasing";
			
			else 
				temperatureTrend = "Stable";
			
		}
		
	}
	
	public static void findMaxMinTemp() {
		
		if(roundCount == 1) {
			
			minTemperature = currentTemperature;
			maxTemperature = currentTemperature;
		}
		
		else {
			
			if(currentTemperature > maxTemperature){
				
				maxTemperature = currentTemperature;
			}
			
			else if(currentTemperature < minTemperature) {
				
				minTemperature = currentTemperature;
			}
		}
	}
	
	public static void findHumidityTrend() {
		
		if(roundCount != 1) {
			
			if(currentHumidity > prevHumidity)
				humidityTrend = "Increasing";
			
			else if(currentHumidity < prevHumidity)
				humidityTrend = "Decreasing";
			
			else 
				humidityTrend = "Stable";
			
		}
		
	}
	
	public static void findMaxMinHumidity() {
		
		if(roundCount == 1) {
			
			minHumidity = currentHumidity;
			maxHumidity = currentHumidity;
		}
		
		else {
			
			if(currentHumidity > maxHumidity){
				
				maxHumidity = currentHumidity;
			}
			
			else if(currentHumidity < minHumidity) {
				
				minHumidity = currentHumidity;
			}
		}
	}
	
	public static void humidity_Status(int curr_humidity) {
	
		if(curr_humidity > HIGH_HUMIDITY) {
			
			humidityStatus = "High";
		}
		
		else if(curr_humidity < LOW_HUMIDITY) {
			
			humidityStatus = "Low";
		}
		
		else {
			humidityStatus = "OK";
		}
		
	}
	
	public static void displayHumidityInformation() {
		
		System.out.println("---------------------------------");
		System.out.println("Current Humidity: " + currentHumidity + "%");
		System.out.println("Maximum Humidity: " + maxHumidity + "%");
		System.out.println("Minimum Humidity: " + minHumidity + "%");
		System.out.println("Humidity Trend: " + humidityTrend);
		System.out.println("Humidity Check: " + humidityStatus);
	}
	
	public static void displayTemperatureInformation() {
		
		System.out.println("");
		System.out.println("Current Temperature: " + currentTemperature);
		System.out.println("Maximum Temperature: " + maxTemperature);
		System.out.println("Minimum Temperature: " + minTemperature);
		System.out.println("Temperature Trend: " + temperatureTrend);
		System.out.println("---------------------------------");
		System.out.println("");
	}
	
	public static void reset() {
		
		currentTemperature = 0;
		currentHumidity = 0;
		
		prevTemperature = 0;
		prevHumidity = 0;
		
		minTemperature = MIN_TEMPERATURE;
		maxTemperature = MAX_TEMPERATURE;
				
		minHumidity = MIN_HUMIDITY;
		maxHumidity = MAX_HUMIDITY;
		
		humidityTrend = "Stable";
		temperatureTrend = "Stable";
		
		humidityStatus = "OK";
		
		roundCount = 0;
	}
	
	

}
