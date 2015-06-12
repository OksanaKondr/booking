package tests;

import objects.TrainsSearchPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import objects.TrainsSearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
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
   
    @BeforeClass
    public void init() throws IOException {

	driver = setUp();
	page = new TrainsSearchPage(driver);
	page = PageFactory.initElements(driver, TrainsSearchPage.class);
	
	}

    @Test
    @Features("Demo")
    @Stories("Demo test")
    public void testDemo() throws Exception {
    	
    	WebElement train;
    	
    	page.stationFrom("Kyiv");
    	page.stationTill("Odesa");
    	page.date();
    	page.setDate();
    	page.time();
    	page.setTime();

    	page.trainsSearch();

    	//Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='ts_res_tbl']")).isEnabled());
  
    	Assert.assertTrue(page.trainsEnsure("148 К"));
    
    	//Assert.assertTrue(page.trainsEnsure("105 К"));
    }

   
    @AfterClass
    public void shutDown() {
	driver.quit();
    }

}