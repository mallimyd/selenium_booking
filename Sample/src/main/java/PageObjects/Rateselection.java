package PageObjects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.junit.Assert;
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

import com.opencsv.CSVWriter;

public class Rateselection {

	
	WebDriver driver;
	
	By flex_label = By.xpath("//*[contains(@class, 'base-typography') and contains(text(), 'Flex') and not(contains(text(), '-'))]");
	By hotel_rate_flex = By.xpath("//*[contains(@class, 'base-typography') and contains(text(), 'Flex') and not(contains(text(), '-'))]//ancestor::div[@class='grid-row']/div[2]/label");
	By booking = By.xpath("//button[text()='Book now']");
	By hotel_rate_text = By.xpath("//*[contains(@class, 'tarrif')]");
	By hotel_booking_name = By.xpath("//*[contains(@class, '__hotel')]");
	
	
	public Rateselection(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void hotel_rate_selection() throws InterruptedException {
		
		Thread.sleep(5000);
		
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(flex_label));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(hotel_rate_flex));
		
	}
	
	public void hotel_booking() {
		
		driver.findElement(booking).click();
		
	}
	
	
	public void hotel_rate_text_verification(String hotel_rate_text_expected) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String hotel_rate_type = driver.findElement(hotel_rate_text).getText();
		Assert.assertEquals(hotel_rate_text_expected, hotel_rate_type);
	}
	
	public void csv_writing() throws IOException {
		
		FileWriter file = new FileWriter("C:\\Users\\malli\\Desktop\\testing.csv");

		String hotel_name = driver.findElement(hotel_booking_name).getText();
		System.out.println(hotel_name);
		file.append("\n");
		file.write(hotel_name);
		file.close();
	}
	
	

}
	
	

