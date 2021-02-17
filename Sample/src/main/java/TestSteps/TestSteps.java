package TestSteps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObjects.Homepage;
import PageObjects.Hotelresults;
import PageObjects.Rateselection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps  {
	
	WebDriver driver;
	
	Homepage homepage;
	Hotelresults hotelresults;
	Rateselection rateselection;
 
	
	@Given("the user initiates webdriver")
	public void startup() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\malli\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.premierinn.com/gb/en/home.html");
		
		
		if(driver.findElement(By.xpath("//button[text()='I consent']")).isDisplayed()) {
			
			driver.findElement(By.xpath("//button[text()='I consent']")).click();
		}
		
		
	}
	
	@When("^the user enters \"([^\"]*)\" Hotel details to search")
//	@When("^the user enters \"(.*)\" Hotel details to search^")
	public void navigation(String hotel_name) {
		homepage = new Homepage(driver);
		homepage.hotel_selection(hotel_name);
		homepage.hotel_search();
	}
	
	@And("the user clicks hotel from the list")
	public void hotel_clicking() {
		
		hotelresults = new Hotelresults(driver);
		hotelresults.hotel_results_selection();
		
	}
	
	@And("the user selects Flex rate and proceeds with booking")
	public void hotel_rate_selection() throws InterruptedException {
		rateselection = new Rateselection(driver);
		rateselection.hotel_rate_selection();
		rateselection.hotel_booking();
	}
	
	
	@And("the user verifies hotel rate text")
	public void hotel_rate_text() throws IOException {
		rateselection.hotel_rate_text_verification("Flex");
		rateselection.csv_writing();
	}
	
	
	@Then("user closed the browser")
	public void quit() {
		
		driver.close();
	}

}
