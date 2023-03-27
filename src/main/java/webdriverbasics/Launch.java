package webdriverbasics;

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
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Launch {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harsh\\Documents\\sel driver\\chromedriver.exe");
        WebDriver driver;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        
        driver.get(" https://www.acerentacar.com/Locations");
        
        Thread.sleep(5000);
        
        
        WebElement cityName1=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[1]/li"));
        cityName1.click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/p")));
        
        String Location1=driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div[1]/div[1]/p")).getText();
        Location1+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[1]")).getText(); 
        Location1+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div[1]/div[1]/span[2]")).getText();
        Location1+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div[1]/div[1]/span[4]")).getText();
        System.out.println(Location1);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[2]/li")));
        
        WebElement cityName2=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[2]/li"));
        cityName2.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/p")));
        
        String Location2=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/p")).getText();
        Location2+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[1]")).getText(); 
        Location2+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[2]")).getText();
        Location2+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location2);
        Thread.sleep(2000);
        
        String Location3=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/p")).getText();
        Location3+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[1]")).getText(); 
        Location3+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[2]")).getText();
        Location3+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location3);
        Thread.sleep(2000);
        
        String Location4=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[1]/p")).getText();
        Location4+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[1]/span[1]")).getText(); 
        Location4+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[1]/span[2]")).getText();
        Location4+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[4]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location4);
        Thread.sleep(2000);
        
        String Location5=driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/p")).getText();
        Location5+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[1]")).getText(); 
        Location5+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[2]")).getText();
        Location5+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[4]")).getText();
        System.out.println(Location5);
        Thread.sleep(2000);
        
        String Location6=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/p")).getText();
        Location6+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/span[1]")).getText(); 
        Location6+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/span[2]")).getText();
        Location6+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location6);
        Thread.sleep(2000);
        
        driver.navigate().back();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[18]/li")));
        
        WebElement cityName3=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div/div[2]/ul/div[18]/li"));
        cityName3.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/p")));
        
        String Location7=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/p")).getText();
        Location7+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[1]")).getText(); 
        Location7+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[2]")).getText();
        Location7+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[1]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location7);
        Thread.sleep(2000);
        
        String Location8=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/p")).getText();
        Location8+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[1]")).getText(); 
        Location8+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[2]")).getText();
        Location8+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[1]/span[4]")).getText();
        System.out.println(Location8);
        Thread.sleep(2000);
        
        String Location9=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/p")).getText();
        Location9+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/span[1]")).getText(); 
        Location9+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div/div[1]/span[2]")).getText();
        Location9+="\n"+driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[3]/div/div[1]/div[1]/span[4]")).getText();
        System.out.println(Location9);
        Thread.sleep(2000);
        
        String Location10=driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/p")).getText();
        Location10+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[1]")).getText(); 
        Location10+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[2]")).getText();
        Location10+="\n"+driver.findElement(By.xpath("//*[@id=\"location_detail_last_location__c82el\"]/div/div[1]/span[4]")).getText();
        System.out.println(Location10);
        Thread.sleep(2000);
	}
}
