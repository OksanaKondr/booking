package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import objects.TrainsSearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	driver.manage().window().maximize();
	page = PageFactory.initElements(driver, TrainsSearchPage.class);
	}

    @Test
    @Features("Demo")
    @Stories("Demo test")
    public void testDemo() throws Exception {
    	page.stationFrom("Ky");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.setStationFrom();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.stationTill("Od");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.setStationTill();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.date();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.setDate();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.time();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.setTime();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	page.trainsSearch();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	driver.findElement(By.xpath("//*[@id='ts_res_tbl']")).isEnabled();
    	//Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='ts_res_tbl']/tbody/*/td[@class='num']/a[text()='148 К']")).isEnabled());
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Assert.assertEquals(true, driver.findElement(By.xpath(".//*[@id='ts_res_tbl']/tbody/*/td[@class='num']/a")).isEnabled());
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//Assert.assertTrue(page.trainsEnsure("148 К"));
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//Assert.assertTrue(page.trainsEnsure("105 К"));
    }

   
    @AfterClass
    public void shutDown() {
	driver.quit();
    }

}