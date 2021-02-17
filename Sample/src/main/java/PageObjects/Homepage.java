package PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	
	public WebDriver driver;
	
	By hotel_location = By.xpath("//input[@placeholder='Enter place, postcode or hotel']");
	By search	 = By.cssSelector(".search-console__container--search-button");
	By checkin = By.xpath("//input[@placeholder='Check in / Check out']");
	
	String from_date = "2021-02-27";
	String to_date = "2021-02-28";
	
	By from_date_element = By.xpath("//button[@data-date='"+from_date+"']");
	By to_date_element = By.xpath("//button[@data-date='"+to_date+"']");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebDriver asetup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\malli\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.premierinn.com/gb/en/home.html");
		return driver;
	}
	
	
	
	
	public void hotel_selection(String str) {
		
		driver.findElement(hotel_location).sendKeys(str);
				
		driver.findElement(checkin).click();
		
		driver.findElement(from_date_element).click();
		driver.findElement(to_date_element).click();
		
	}
	
	
	public void hotel_search() {
		
		driver.findElement(search).click();
	}
}
	
	
