package tests;

import objects.TrainsSearchPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import utils.DriverSetup;


public class OksanaBookingTest extends DriverSetup {

    WebDriver driver;
    TrainsSearchPage page;
    String from = "Kyiv";
	String till = "Odesa";
    String date = "07.19.2015";
    String time = "10:00";
   
    @BeforeClass
    public void init() throws IOException {

	driver = setUp();
	page = new TrainsSearchPage(driver);

	}

    @Test
    @Features("Demo")
    @Stories("Demo test")
    public void testDemo() throws Exception {
    	    	
    	page.stationFrom(from);
    	page.stationTill(till);
    	page.setDate(date);
    	page.setTime(time);
    	page.trainsSearch();

    	Assert.assertTrue(page.isTrainTableEnabled());
    	Assert.assertTrue(page.trainsEnsure("148 К"));
    	Assert.assertTrue(page.trainsEnsure("105 К"));
  
    }    	
 
    @AfterClass
    public void shutDown() {
	driver.quit();
    }
}