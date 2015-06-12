package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class TrainsSearchPage {

	WebDriver driver;

	public TrainsSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='station_from']")
	private WebElement from;

	@FindBy(xpath = "//input[@name='station_till']")
	private WebElement till;
	
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

	@FindBy(xpath = ".//*[@class='num']")  
	private WebElement train;

	@Step
	public void stationFrom(String value) {
		from.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Kyiv']")));
		driver.findElement(By.xpath("//div[@title='Kyiv']")).click();
	}

	@Step
	public void stationTill(String value) {
		till.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Odesa']")));
		driver.findElement(By.xpath("//div[@title='Odesa']")).click();
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

		return train.getText().contains(text);
	}

}