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

public class Hotelresults {

	
	WebDriver driver;
	
	By hotel_result_selection = By.xpath("//*[@id='hotel-card-1']");
	
	
	public Hotelresults(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void hotel_results_selection() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(hotel_result_selection)).click();
		
	}
	
}
	
	

