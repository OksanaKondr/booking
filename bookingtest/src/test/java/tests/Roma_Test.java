package tests;

import java.io.IOException;

import objects.RomaBookingPage;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.DriverSetup;
//import org.openqa.selenium.WebElement;

public class Roma_Test extends DriverSetup{

	WebDriver driver;
	RomaBookingPage bookingPage;
	String from = "Kyiv";
	String till = "Odesa";
	String date = "06.12.2015";
	
	
	@BeforeClass
	public void startUp() throws IOException {

		/*driver = new FirefoxDriver();
		driver.get("http://booking.uz.gov.ua/en/");
		driver.manage().window().maximize();*/
	    
	    driver = setUp();
		bookingPage=PageFactory.initElements(driver,RomaBookingPage.class);

	}

	@Test
	public void RomanTestTableIsPresent() throws InterruptedException {
		
		bookingPage.enterStationFrom(from);
		bookingPage.enterStationTill(till);
		bookingPage.enterDate(date);
		bookingPage.submitbuttonSearch();
		bookingPage.trainsTable();
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='ts_res_tbl']")).isEnabled());
		
							
	}

	@Test
	public void RomanTestTrainIsPresent() throws InterruptedException {
		
		bookingPage.cleanUpAll();
		bookingPage.enterStationFrom(from);
		bookingPage.enterStationTill(till);
		bookingPage.enterDate("06.12.2015");
		bookingPage.submitbuttonSearch();
		bookingPage.trainsTable();
	
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='num']/a")).getText(), "763 К");
		
	}	
	
	@AfterClass
	public void shutDown() {
		driver.quit();
	}

}