package tests;

import java.io.IOException;

import objects.YarikBookingPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import utils.DriverSetup;

/**
 * @author y.pernerovskyy
 *
 */
public class YarikBookingTest extends DriverSetup {

    WebDriver driver;
    private YarikBookingPage book;

    @BeforeClass
    public void init() throws IOException {
	driver = setUp();
	book = new YarikBookingPage(driver);
    }

    @Test
    @Features("Demo")
    @Stories("Demo test")
    public void testDemo() throws Exception {

	book.search_from("Kyiv");
	book.search_to("Ivano-Frankivsk");
	book.clickSearch();
    }

    @AfterClass
    public void shutDown() {
	driver.quit();
    }

}
