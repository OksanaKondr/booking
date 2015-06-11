package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainsSearchPage {

	WebDriver driver;

	public TrainsSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ".//*[@id='station_from']/input")
	private WebElement from;

	@FindBy(xpath = ".//*[@id='station_till']/input")
	private WebElement till;

	@FindBy(xpath = ".//*[@id='stations_from']")
	private WebElement stationFrom;

	@FindBy(xpath = ".//*[@id='stations_till']")
	private WebElement stationTill;

	@FindBy(xpath = "//div[@title='Kyiv']")
	private WebElement kiev;

	@FindBy(xpath = "//div[@title='Odesa']")
	private WebElement odesa;

	@FindBy(xpath = ".//*[@id='date_dep']")
	private WebElement date;

	@FindBy(xpath = ".//*[@class='grid']")
	private WebElement dateTable;

	@FindBy(xpath = ".//*[@name='time_dep']")
	private WebElement time;

	@FindBy(xpath = ".//*/table[@class='month']/caption[text()='July 2015']/../tbody/*/td[text()='19']")
	private WebElement depDate;

	@FindBy(xpath = ".//*/select[@name='time_dep']/option[@value='10:00']")
	private WebElement depTime;

	@FindBy(xpath = ".//*[@id='content']/form/p/button")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='ts_res_tbl']")
	private WebElement trainTable;

	@FindBy(xpath = ".//*[@id='ts_res_tbl']/tbody/*/td[@class='num']/a")
	private WebElement train;

	public void stationFrom(String value) {
		from.sendKeys(value);
	}

	public void stationTill(String value) {
		till.sendKeys(value);
	}

	public void setStationFrom() {
		kiev.click();
	}

	public void setStationTill() {
		odesa.click();
	}

	public void date() {
		date.click();
	}

	public void time() {
		time.click();
	}

	public void setDate() {
		depDate.click();
	}

	public void setTime() {
		depTime.click();
	}

	public void trainsSearch() {
		searchButton.click();
	}

	public boolean trainsEnsure(String text) {
		boolean b = false;

		if (driver.findElement(By.id("train")).getText().equals(text))
			b = true;
		return b;
	}

}