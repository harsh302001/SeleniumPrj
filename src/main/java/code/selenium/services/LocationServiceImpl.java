package code.selenium.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import code.selenium.entities.Location;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;

@Component
public class LocationServiceImpl {
	public static List<Location> cities = new ArrayList<>();

	public List<Location> getAllLocations() throws InterruptedException {

		//Initializing Chrome Webdriver to open Chrome and perform Operation
		
		WebDriver driver;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		//Initializing chrome driver object
		driver = new ChromeDriver(option);
		
		//maximize window
		driver.manage().window().maximize();

		//method to go to the rent a car website
		driver.get(" https://www.acerentacar.com/Locations");
		Thread.sleep(5000);

		//find element and click on the city name
		WebElement cityName1 = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[1]/li"));
		cityName1.click();

		//Initializing wait object for wait the screen for 30 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String str = "//*[@id=\"location_detail_last_location__c82el\"]/div[1]/div[1]/";
		
		//pause the operation until the element is present on the screen
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str + "p")));

		//declaring local variables to temperory store data
		String address1 = "", ph_no1 = "", loc_typ1 = "", loc_hr1 = "";
		String city1 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i < 3; i++)
			address1 += driver.findElement(By.xpath(str + "span[" + i + "]")).getText()+"\n";

		ph_no1 = driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ1 = driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[2]"))
				.getText();
		loc_hr1 = driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[3]"))
				.getText();
		//save data to the list
		cities.add(new Location(city1, address1, ph_no1, loc_typ1, loc_hr1));
		System.out.println(city1 + address1 + ph_no1 + loc_typ1 + loc_hr1);
        //sleep method to pause the screen for loading page
		Thread.sleep(2000);
		//method to navigate to the previous page
		driver.navigate().back();
		Thread.sleep(5000);

		//wait is used to wait the screen until the given condition is true
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[2]/li")));

		//element to click on another city
		WebElement cityName2 = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[2]/li"));
		cityName2.click();

		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str + "p")));

		String address2 = "", ph_no2 = "", loc_typ2 = "", loc_hr2 = "";
		String city2 = driver.findElement(By.xpath(str + "p")).getText();
		//Iterating to navigate to different elements of the website
		for (int i = 1; i < 3; i++)
			address2 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();

		ph_no2 = "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ2 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[2]")).getText();
		loc_hr2 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[3]")).getText();
		cities.add(new Location(city2, address2, ph_no2, loc_typ2, loc_hr2));
		System.out.println(city2 + address2 + ph_no2 + loc_typ2 + loc_hr2);
		Thread.sleep(2000);

		//local variables to store data temporary
		String address3 = "", ph_no3 = "", loc_typ3 = "", loc_hr3 = "";
		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/";
		String city3 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i < 3; i++)
			address3 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		ph_no3 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ3 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[2]")).getText();
		loc_hr3 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[3]")).getText();
		//List datatype to store data
		cities.add(new Location(city3, address3, ph_no3, loc_typ3, loc_hr3));
		System.out.println(city3 + address3 + ph_no3 + loc_typ3 + loc_hr3);
		//sleep used to wait the screen for 2 seconds for reloading of page
		Thread.sleep(2000);

		//local variables to store data temporary
		String address4 = "", ph_no4 = "", loc_typ4 = "", loc_hr4 = "";
		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[1]/";
		String city4 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i <= 2; i++)
			address4 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		ph_no4 = "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ4 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[2]")).getText();
		loc_hr4 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[3]")).getText();
		//adding the above data into the list
		cities.add(new Location(city4, address4, ph_no4, loc_typ4, loc_hr4));
		System.out.println(city4 + address4 + ph_no4 + loc_typ4 + loc_hr4);
		Thread.sleep(2000);

		//local variables to store data temporarily
		String address5 = "", ph_no5 = "", loc_typ5 = "", loc_hr5 = "";
		str = "//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/";
		String city5 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i <= 2; i++)
			address5 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		ph_no5 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ5 = "\n" + driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[2]"))
				.getText();
		loc_hr5 = "\n" + driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[3]"))
				.getText();
		//adding data to the list with location object
		cities.add(new Location(city5, address5, ph_no5, loc_typ5, loc_hr5));
		System.out.println(city5 + address5 + ph_no5 + loc_typ5 + loc_hr5);
		Thread.sleep(2000);
        
		//declaring local variables for storing data
		String address6 = "", ph_no6 = "", loc_typ6 = "", loc_hr6 = "";
		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/";
		String city6 = driver.findElement(By.xpath(str + "p")).getText();
		//Iterating for accesing data of different elements of a website
		for (int i = 1; i <= 2; i++)
			address6 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		//variable to get phone number from the website
		ph_no6 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		//variable to get location type
		loc_typ6 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[2]")).getText();
		//variable to get location hour
		loc_hr6 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[3]")).getText();
		//storing data in the list cities
		cities.add(new Location(city6, address6, ph_no6, loc_typ6, loc_hr6));
		System.out.println(city6 + address6 + ph_no6 + loc_typ6 + loc_hr6);
		Thread.sleep(2000);

		//navigate to back page
		driver.navigate().back();

		//wait until the required condition is fulfiled
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[18]/li")));

		WebElement cityName3 = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[18]/li"));
		//To click on the city name
		cityName3.click();

		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str + "p")));

		//local variables to store data temporary
		String address7 = "", ph_no7 = "", loc_typ7 = "", loc_hr7 = "";
		String city7 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i <= 2; i++)
			address7 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
        //storing the data
		ph_no7 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ7 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[2]")).getText();
		loc_hr7 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[3]")).getText();
		//passing the data into list named cities
		cities.add(new Location(city7, address7, ph_no7, loc_typ7, loc_hr7));
		System.out.println(city7 + address7 + ph_no7 + loc_typ7 + loc_hr7);
		Thread.sleep(2000);

		//local variables to store data temporary
		String address8 = "", ph_no8 = "", loc_typ8 = "", loc_hr8 = "";
		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/";
		String city8 = driver.findElement(By.xpath(str + "p")).getText();
		//Iterating to elements
		for (int i = 1; i <= 2; i++)
			address8 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		ph_no8 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ8 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[2]")).getText();
		loc_hr8 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[3]")).getText();
		cities.add(new Location(city8, address8, ph_no8, loc_typ8, loc_hr8));
		System.out.println(city8 + address8 + ph_no8 + loc_typ8 + loc_hr8);
		Thread.sleep(2000);

		String address9 = "", ph_no9 = "", loc_typ9 = "", loc_hr9 = "";
		str = "//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/";
		String city9 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i <= 2; i++)
			address9 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		ph_no9 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ9 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[2]")).getText();
		loc_hr9 = "\n" + driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[3]")).getText();
		cities.add(new Location(city9, address9, ph_no9, loc_typ9, loc_hr9));
		System.out.println(city9 + address9 + ph_no9 + loc_typ9 + loc_hr9);
		Thread.sleep(2000);

		//Local variables declaration
		String address10 = "", ph_no10 = "", loc_typ10 = "", loc_hr10 = "";
		str = "//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/";
		String city10 = driver.findElement(By.xpath(str + "p")).getText();
		for (int i = 1; i <= 2; i++)
			address10 += "\n" + driver.findElement(By.xpath(str + "span[" + i + "]")).getText();
		//storing data in variables
		ph_no10 += "\n" + driver.findElement(By.xpath(str + "span[4]")).getText();
		loc_typ10 = "\n" + driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[2]"))
				.getText();
		loc_hr10 = "\n"
				+ driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[3]"))
				.getText();
		//store data into the data structure list
		cities.add(new Location(city10, address10, ph_no10, loc_typ10, loc_hr10));
		System.out.println(city10 + address10 + ph_no10 + loc_typ10 + loc_hr10);
		
        return cities;
	}
}
