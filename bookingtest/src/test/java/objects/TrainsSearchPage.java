package objects;

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
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//input[@name='station_from']")
	private WebElement from;

	@FindBy(xpath = "//input[@name='station_till']")
	private WebElement till;

	@FindBy(xpath = ".//*[@class='grid']")
	private WebElement dateTable;

	@FindBy (name="date_dep")
	private WebElement depDate;

	@FindBy (name="time_dep")
	private WebElement depTime;

	@FindBy(xpath = ".//*[@id='content']/form/p/button")
	private WebElement searchButton;

	@FindBy(xpath = "//table[@id='ts_res_tbl']/tbody")
	private WebElement trainTable;

	@FindBy(xpath = ".//*[@class='num']/a")  
	private WebElement train;
	
	@FindBy(xpath = "//div[@title]")
    private WebElement town;
	
	@FindBy (id="stations_from")
	private WebElement stationFrom;
	
	@FindBy (xpath =".//*[@id='stations_till']/div")
	private WebElement stationTill;

	@Step
	public void stationFrom(String value) {
		from.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(town));
		if (town.getText().contains(value)) town.click();
	}

	@Step
	public void stationTill(String value) {
		till.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(stationTill));
		if (stationTill.getText().contains(value)) stationTill.click();
	}

	public void setDate(String value) {
		depDate.clear();
		depDate.sendKeys(value);
	}

	public void setTime(String value) {
		depTime.sendKeys(value);
	}

	public void trainsSearch() {
		searchButton.click();
	}
	
	public boolean isTrainTableEnabled() {
	     return trainTable.isEnabled();
	}

	public boolean trainsEnsure(String trainNum) {

        for (WebElement number : trainTable.findElements(By.xpath(".//*[@class='num']/a"))) {      	
        	if (number.getText().equals(trainNum)) 
        		{
        		System.out.println(number.getText());
        		return true;
        		}
        	}
        return false;	
	}

}